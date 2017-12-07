package course.monitor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.ConnectionFactory;
import Dao.CourseDaoImp;
import Dao.CourseList;

public class GetCourseByIDandSerial extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "project/courseManage/courseChange.jsp";
		
		int cID = Integer.parseInt(request.getParameter("cID"));
		short cSerial = Short.parseShort(request.getParameter("cSerial"));
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		CourseList courseList = new CourseList();
		try {
			Connection conn = ConnectionFactory.getInstance().makeConnection();
			CourseDaoImp courseDao = new CourseDaoImp();
			courseList.getCourseList().add(courseDao.getCourseByIDandSerial(conn, cID, cSerial));
			System.out.println("(｡◕‿◕｡)成功查询cID=" + cID + "且cSerial=" + cSerial + "的课程！");
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
			System.out.println("(°□°；)查询cID=" + cID + "且cSerial=" + cSerial + "的课程失败！");
		}
		try {
			response.getWriter().println(new Gson().toJson(courseList));
			response.getWriter().flush();
			response.getWriter().close();
			System.out.println("(｡◕‿◕｡)成功将cID=" + cID + "且cSerial=" + cSerial + "的课程返回！");
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("(°□°；)返回cID=" + cID + "且cSerial=" + cSerial + "的课程失败！");
		}
	}

}

