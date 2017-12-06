package course.monitor;

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
import Dao.CourseDaoImp;
import Dao.CourseData.Course;

public class changeAction extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");
	    response.setCharacterEncoding("utf-8");
    	String url = "project/courseManage/courseChange.jsp";
    	
    	int cID = Integer.parseInt(request.getParameter("cID"));
		String cName = request.getParameter("cName");
		int aID = Integer.parseInt(request.getParameter("aID"));
		String tName = request.getParameter("tName");
		String classroom = request.getParameter("classroom");
		String date = request.getParameter("date");
		
		Course course = new Course(cID, aID, tName, cName, classroom, date);
		request.setCharacterEncoding("UTF-8");

		
		try {
			Connection conn = ConnectionFactory.getInstance().makeConnection();
			CourseDaoImp courseDao = new CourseDaoImp();
			courseDao.updateCourseInfo(conn, cID, course);
			System.out.println("修改成功！");
			response.sendRedirect(url);
			} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}
    	}
    }
