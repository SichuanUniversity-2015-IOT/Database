package user.monitor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import Dao.ConnectionFactory;
import Dao.CourseDaoImp;
import Dao.UserData;
import Dao.UserData.Student;
import Dao.UserData.Teacher;
import Dao.CourseData.Course;
import Dao.StudentImp;

public class searchStudentAction extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String name = request.getParameter("name");
    	UserData userData = new UserData();
    	try {
            Connection conn = ConnectionFactory.getInstance().makeConnection();
            StudentImp userStudent = new StudentImp();
            
            List<Student> studentList = userStudent.searchStudent(conn, name);
            userData.setStudentList(studentList);
            
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}
    	
    	
    	response.setContentType("text/html; charset=UTF-8");
    	try {
    		response.getWriter().print(new Gson().toJson(userData));
    		response.getWriter().flush();
    		response.getWriter().close();
    	}catch (IOException e){
    		e.printStackTrace();
    	}
    	System.out.println("返回结果给调用页面了。");
    }
}
