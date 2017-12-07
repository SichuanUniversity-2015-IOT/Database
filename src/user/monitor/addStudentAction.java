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
import Dao.UserData.Student;
import Dao.StudentImp;

public class addStudentAction extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String url = "project/userManage/addStudent.jsp";
    	String sId = request.getParameter("sId");
		String aID = request.getParameter("aID");
		String sName = request.getParameter("sName");
		String AVG = request.getParameter("AVG");
		String sPhone = request.getParameter("sPhone");
		String sEmail = request.getParameter("sEmail");
		String major = request.getParameter("major");
		String minor = request.getParameter("minor");
		request.setCharacterEncoding("UTF-8");

		try {
			Connection conn = ConnectionFactory.getInstance().makeConnection();
    	 	StudentImp userStudent = new StudentImp();
    	 	
    	 	Student student = new Student();
    	 	student.setsID(Integer.parseInt(sId));
    	 	student.setaID(Integer.parseInt(aID));
    	 	student.setsName(sName);
    	 	student.setAVG(Float.parseFloat(AVG));
    	 	student.setsPhone(sPhone);
    	 	student.setsEmail(sEmail);
    	 	student.setsMajor(major);
    	 	student.setsMinor(minor);
    	 	
    	 	userStudent.addStudent(conn, student);
    	 	
			response.sendRedirect(url);
			} catch (SQLException sqlexception) {
			    sqlexception.printStackTrace();
		}
  	}
}
