package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.CourseData.Course;;

public class CourseDaoImp implements CourseDao{

	@Override
	public List<Course> getCourseList(Connection conn) throws SQLException {
		List<Course> courseList = new ArrayList<Course>();
		Statement statement = conn.createStatement();
    	//System.out.println("Connect Database Ok！！！");
    	//执行查询语句，返回结果集
    	String sql = "select * from course";
    	System.out.println("查询全部课程的sql："+sql);
    	ResultSet rs = statement.executeQuery(sql);
    	while (rs.next()) {
    		Course course = new Course();
    		course.setaID(rs.getInt("aID"));
    		course.setcID(rs.getInt("cID"));
    		course.setClassroom(rs.getString("classroom"));
    		course.setcName(rs.getString("cName"));
    		course.setDate(rs.getString("time"));
    		course.setfilled(rs.getString("status"));
    		course.settName("kerwin");
    		
    		courseList.add(course);
    	}
	
    	statement.close();
    	//System.out.println("Database Closed！！！");
		return courseList;
	}

	@Override
	public Course getCourse(Connection conn, int id) throws SQLException {
		Course course = new Course();
		Statement statement = conn.createStatement();
		String sql = null;
		//System.out.println("Connect Database Ok！！！");
		
		sql = "select * from course where cID = " + id;
		System.out.println("查询id为"+id+"的课程："+sql);
		
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		course.setaID(rs.getInt("aID"));
		course.setcID(rs.getInt("cID"));
		course.setClassroom(rs.getString("classroom"));
		course.setcName(rs.getString("cName"));
		course.setDate(rs.getString("time"));
		course.setfilled(rs.getString("status"));
		course.settName("kerwin");
		
		statement.close();
    	//System.out.println("Database Closed！！！");
		return course;
	}

	@Override
	public List<Course> searchCourses(Connection conn, String cName) throws SQLException {
		Statement statement = conn.createStatement();
		List<Course> courseList = new ArrayList<Course>();
		//System.out.println("Connect Database Ok！！！");
		//执行查询语句，返回结果集
		String sql = "select * from course where cName='"+cName+"'";
		//System.out.println("构造出来的sql语句是："+sql);
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Course course = new Course();
			course.setaID(rs.getInt("aID"));
    		course.setcID(rs.getInt("cID"));
    		course.setClassroom(rs.getString("classroom"));
    		course.setcName(rs.getString("cName"));
    		course.setDate(rs.getString("time"));
    		course.setfilled(rs.getString("status"));
    		course.settName("kerwin");
    		
    		courseList.add(course);
		}
	
		statement.close();
		
		//System.out.println("Database Closed！！！");
		return courseList;
	}

	@Override
	public void updateCourseInfo(Connection conn, int id, Course course) throws SQLException {
		Statement statement = conn.createStatement();
		int aID = course.getaID();
		String cName = course.getcName();
		//String tName = course.gettName();
		String classroom = course.getClassroom();
		//boolean filled = course.isfilled();
		
		String sql = "update course set aID = "+ aID +", "
				+ "cName = '"+ cName +"', classroom = '"+classroom+"' "
						+ "WHERE cID = "+ id;
		System.out.println("构造出来的sql语句是："+sql);
		statement.executeUpdate(sql);
	}
}
