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
import Dao.CourseData;
import Dao.CourseData.Course;
import Dao.CourseDaoImp;

public class queryallAction extends HttpServlet{
		public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }

	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	CourseData courseData = new CourseData();
	    	HttpSession session=request.getSession();

             try {
            	 Connection conn = ConnectionFactory.getInstance().makeConnection();
                 CourseDaoImp courseDao = new CourseDaoImp();
                 List<Course> courseList = courseDao.getCourseList(conn);
                 courseData.setCourseData(courseList);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			session.setAttribute("courseCount", courseData.getCourseList().size()+"");
			response.setContentType("text/html; charset=UTF-8");
			
	    	try {
	    		System.out.println(new Gson().toJson(courseData));
	    		session.setAttribute("courseData", new Gson().toJson(courseData));
	    		response.getWriter().print(new Gson().toJson(courseData));
	    		response.getWriter().flush();
	    		response.getWriter().close();
	    	}catch (IOException e){
	    		e.printStackTrace();
	    	}
		}
}
