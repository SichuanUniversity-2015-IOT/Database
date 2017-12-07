package course.monitor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ConnectionFactory;
import Dao.CourseDaoImp;

public class UpdateCourseInfo extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String url = "project/courseManage/courseChange.jsp";
		
/*		String aName, int cID, String cName, short cSerial, float cCredit,
        String pWeek, String pTime, String pClassroom, short tID*/
		String aName = request.getParameter("aName");
		int cID = Integer.parseInt(request.getParameter("cID"));
		String cName = request.getParameter("cName");
		short cSerial = Short.parseShort(request.getParameter("cSerial"));
		float cCredit = Float.parseFloat(request.getParameter("cCredit"));
		String pWeek = request.getParameter("cWeek");
		String pTime = request.getParameter("cTime");
		String pClassroom = request.getParameter("cRoom");
		short tID = Short.parseShort(request.getParameter("tID"));
		
		request.setCharacterEncoding("UTF-8");
		try {
			Connection conn = ConnectionFactory.getInstance().makeConnection();
			CourseDaoImp courseDao = new CourseDaoImp();
			courseDao.updateCourseInfo(conn, aName, cID, cName, cSerial, cCredit, pWeek, pTime, pClassroom, tID);
			System.out.println("(｡◕‿◕｡)成功更新课程！");
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
			System.out.println("(°□°；)更新课程失败！");
		}
	}
}
