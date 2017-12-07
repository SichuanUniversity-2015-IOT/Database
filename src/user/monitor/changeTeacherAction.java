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
import Dao.TeacherImp;

public class changeTeacherAction extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String url = "project/userManage/userChange.jsp";
    	String tId = request.getParameter("tId");
		String aID = request.getParameter("aID");
		String tName = request.getParameter("tName");
		String tTitle = request.getParameter("tTitle");
		String tField = request.getParameter("tField");
		String tPhone = request.getParameter("tPhone");
		String tEmail = request.getParameter("tEmail");
		request.setCharacterEncoding("UTF-8");

		try {
			Connection conn = ConnectionFactory.getInstance().makeConnection();
    	 	TeacherImp userTeacher = new TeacherImp();
    	 	
    	 	Teacher teacher = new Teacher();

    	 	teacher.settID(Integer.parseInt(tId));
    	 	teacher.setaID(Integer.parseInt(aID));
    	 	teacher.settName(tName);
    	 	teacher.settTitle(tTitle);
    	 	teacher.settField(tField);
    	 	teacher.settPhone(tPhone);
    	 	teacher.settEmail(tEmail);
    	 	userTeacher.updateTeacher(conn, Integer.parseInt(tId), teacher);
    	 	
			response.sendRedirect(url);
			} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}
    	}
    }
