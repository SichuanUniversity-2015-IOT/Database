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
import Dao.TeacherImp;
import Dao.UserData.Teacher;

public class queryTeacherAction extends HttpServlet{
		public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }

	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	String id=request.getParameter("id");
	    	response.setContentType("text/html; charset=UTF-8");
	    	
            try {
            	Connection conn = ConnectionFactory.getInstance().makeConnection();
        	 	TeacherImp userTeacher = new TeacherImp();
				
				Teacher teacher = userTeacher.getTeacher(conn, Integer.parseInt(id));
				response.getWriter().print(new Gson().toJson(teacher));
		    	response.getWriter().flush();
		    	response.getWriter().close();
		    		//System.out.println("teacher");
				
				conn.close();
			} catch (SQLException sqlexception) {
				sqlexception.printStackTrace();
			}
            //System.out.println("end");
		}
}
