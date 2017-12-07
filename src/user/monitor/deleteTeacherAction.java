package user.monitor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ConnectionFactory;
import Dao.TeacherImp;

public class deleteTeacherAction extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String url = "project/userManage/deleteTeacher.jsp";
    	String sID = request.getParameter("sID");
		request.setCharacterEncoding("UTF-8");

		try {
			Connection conn = ConnectionFactory.getInstance().makeConnection();   	
			TeacherImp userStudent = new TeacherImp();
    	 	
    	 	userStudent.deleteTeacher (conn, Integer.parseInt(sID));
    	 	
			response.sendRedirect(url);
			} catch (SQLException sqlexception) {
			    sqlexception.printStackTrace();
		}
  	}
}
