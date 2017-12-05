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
import Dao.UserData.Teacher;
import Dao.TeacherImp;

public class changeTeacherAction extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String url = "project/userManage/userChange.jsp";
    	String id = request.getParameter("id");
		String name = request.getParameter("name");
		String aID = request.getParameter("aID");
		String email = request.getParameter("email");
		String major = request.getParameter("major");
		request.setCharacterEncoding("UTF-8");

		try {
			Connection conn = ConnectionFactory.getInstance().makeConnection();
    	 	TeacherImp userTeacher = new TeacherImp();
    	 	
    	 		Teacher teacher = new Teacher();
    	 		teacher.setaID(Integer.parseInt(aID));
    	 		teacher.settID(Integer.parseInt(id));
    	 		teacher.settEmail(email);
    	 		teacher.settField(major);
    	 		teacher.settName(name);
    	 		userTeacher.updateTeacher(conn, Integer.parseInt(id), teacher);
    	 	
			response.sendRedirect(url);
			} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}
    	}
    }
