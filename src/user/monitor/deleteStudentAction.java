package user.monitor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ConnectionFactory;
import Dao.StudentImp;

public class deleteStudentAction extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String url = "project/userManage/deleteStudent.jsp";
    	String sID = request.getParameter("sId");
		request.setCharacterEncoding("UTF-8");

		try {
			Connection conn = ConnectionFactory.getInstance().makeConnection();   	
			StudentImp userStudent = new StudentImp();
    	 	
    	 	userStudent.deleteStudent(conn, Integer.parseInt(sID));
    	 	
			response.sendRedirect(url);
			} catch (SQLException sqlexception) {
			    sqlexception.printStackTrace();
		}
  	}
}
