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
import Dao.UserDaoImp;
import Dao.UserData.Student;
import Dao.UserData.Teacher;
import Dao.StudentImp;

public class changeStudentAction extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String url = "project/userManage/userChange.jsp";
    	String sId = request.getParameter("sId");
		String aID = request.getParameter("aID");
		String name = request.getParameter("sName");
		String AVG = request.getParameter("AVG");
		String sPhone = request.getParameter("sPhone");
		String sEmail = request.getParameter("sEmail");
		request.setCharacterEncoding("UTF-8");

		try {
			Connection conn = ConnectionFactory.getInstance().makeConnection();
    	 	StudentImp userStudent = new StudentImp();
    	 	
    	 	Student student = new Student();
    	 	student.setsID(Integer.parseInt(sId));
    	 	student.setaID(Integer.parseInt(aID));
    	 	student.setsName(name);
    	 	student.setAVG(Float.parseFloat(AVG));
    	 	student.setsPhone(sPhone);
    	 	student.setsEmail(sEmail);
    	 	
    	 	userStudent.updateStudent(conn, Integer.parseInt(sId), student);
    	 	
			response.sendRedirect(url);
			} catch (SQLException sqlexception) {
			    sqlexception.printStackTrace();
		}
  	}
}
