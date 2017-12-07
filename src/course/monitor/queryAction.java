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
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import Dao.ConnectionFactory;
import Dao.CourseDaoImp;
import Dao.CourseData.Course;

public class queryAction extends HttpServlet{
		public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }

	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	String cID=request.getParameter("cID");
	    	
	    	Course course = new Course();	
	    	try{
            	Connection conn = ConnectionFactory.getInstance().makeConnection();
				CourseDaoImp courseDao = new CourseDaoImp();
				
				course = courseDao.getCourse(conn, Integer.parseInt(cID));
	    	}catch (SQLException sqlexception) {
				sqlexception.printStackTrace();
			}

	    	response.setContentType("text/html; charset=UTF-8");
	    	try {
	    		System.out.println(new Gson().toJson(course));
	    		response.getWriter().print(new Gson().toJson(course));
	    		response.getWriter().flush();
	    		response.getWriter().close();
	    	}catch (IOException e){
	    		e.printStackTrace();
	    	}
	    	System.out.println("返回结果给调用页面了。");
		}
}
