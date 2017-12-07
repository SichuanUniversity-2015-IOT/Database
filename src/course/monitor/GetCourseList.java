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

public class GetCourseList extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "project/courseManage/courseChange.jsp";
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		CourseList courseList = new CourseList();
		try {
			Connection conn = ConnectionFactory.getInstance().makeConnection();
			CourseDaoImp courseDao = new CourseDaoImp();
			courseList.setCourseList(courseDao.getCourseList(conn));
			System.out.println("(｡◕‿◕｡)成功查询全部课程！");
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
			System.out.println("(°□°；)查询课程返回失败！");
		}
		try {
			response.getWriter().println(new Gson().toJson(courseList));
			response.getWriter().flush();
			response.getWriter().close();
			System.out.println("(｡◕‿◕｡)成功将删除后的剩余课程返回！");
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("(°□°；)剩余课程返回失败！");
		}
	}

}
