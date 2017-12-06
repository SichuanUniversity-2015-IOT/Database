package course.monitor;

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
import Dao.CourseData;
import Dao.CourseData.Course;

public class searchAction extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String cName=request.getParameter("cName");
    	CourseData courseData = new CourseData();

    	try {
            Connection conn = ConnectionFactory.getInstance().makeConnection();
            CourseDaoImp courseDao = new CourseDaoImp();
            List<Course> courseList = courseDao.searchCourses(conn, cName);
            courseData.setCourseData(courseList);
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}

    	response.setContentType("text/html; charset=UTF-8");
    	try {
    		System.out.println(new Gson().toJson(courseData));
    		response.getWriter().print(new Gson().toJson(courseData));
    		response.getWriter().flush();
    		response.getWriter().close();
    	}catch (IOException e){
    		e.printStackTrace();
    	}
    }
}
