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
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import Dao.ConnectionFactory;
import Dao.StudentImp;
import Dao.TeacherImp;
import Dao.UserData;

public class queryAllStudentAction extends HttpServlet{
		public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }

	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	HttpSession session = request.getSession();
	    	
	    	//int teacherCount = 0;
	    	//int userCount = 0;
	    	int studentCount = 0;
	    	UserData userDataS = new UserData();
	    	
	         try {
	        	 	Connection conn = ConnectionFactory.getInstance().makeConnection();
	        	 	StudentImp userStudent = new StudentImp();
	        	 	userDataS = userStudent.getUserData(conn);
	        	 	studentCount = userDataS.getStudentList().size();
	        	 	
	    		} catch (SQLException sqlexception) {
	    			sqlexception.printStackTrace();
	    		}
	
			session.setAttribute("userDataS",new Gson().toJson(userDataS));
			//session.setAttribute("teacherCount", teacherCount+"");
			//session.setAttribute("userCount", userCount+"");
			session.setAttribute("studentCount", studentCount+"");
				
	    	response.setContentType("text/html; charset=UTF-8");
	    	try {
	    		System.out.println(new Gson().toJson(userDataS));
	    		response.getWriter().print(new Gson().toJson(userDataS));
	    		response.getWriter().flush();
	    		response.getWriter().close();
	    	}catch (IOException e){
	    		e.printStackTrace();
	    	}
		}
}
