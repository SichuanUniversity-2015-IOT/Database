package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Dao.CourseList;
import Dao.CourseList.Course;

public class CourseDaoImp implements CourseDao {

	@Override
	public void insertCourse(Connection conn, String aName, int cID, String cName, short cSerial, float cCredit,
			                 String pWeek, String pTime, String pClassroom, short tID) throws SQLException {
		Statement statement = conn.createStatement();
		String searchaID = "select aID from academy where aName = '" + aName + "'";
		ResultSet rsaID = statement.executeQuery(searchaID);
		rsaID.next();
		String insertIntoCourse = "insert into course (cID, cName, cSerial, cCredit, aID) "
				+ "values (" + cID + ", '" + cName + "', " + cSerial + ", " + cCredit + ", " + rsaID.getShort("aID") + ")";
		String insertIntoProvide = "insert into provide (cID, cSerial, tID, pTime, pClassroom, pWeek) "
				+ "values (" + cID + ", " + cSerial + ", " + tID + ", '" + pTime + "', '" + pClassroom + "', '" + pWeek + "')";
		statement.executeUpdate(insertIntoCourse);
		System.out.println("向course表中增加记录: " + insertIntoCourse);
		statement.executeUpdate(insertIntoProvide);
		System.out.println("向provide表中增加记录: " + insertIntoProvide);
		
		statement.close();
	}
	
	@Override
	public List<Course> deleteCourse(Connection conn, int cID, short cSerial) throws SQLException {
		List<Course> courseList = new ArrayList<Course>();
		Statement statement = conn.createStatement();
		String deleteFromProvide = "delete from provide where cId = " + cID + " and cSerial = " +cSerial;
		String deleteFromLearn = "delete from learn where cId = " + cID + " and cSerial = " +cSerial;
		String deleteFromCourse = "delete from course where cId = " + cID + " and cSerial = " +cSerial;
		if(statement.execute(deleteFromProvide) && statement.execute(deleteFromLearn) && statement.execute(deleteFromCourse)) {
			System.out.println("删除cID=" + cID + "且cSerial=" + cSerial +"的课程");
			courseList = getCourseList(conn);	//返回删除后的剩余全部课程
		}
		statement.close();
		return courseList;
	}
	
	@Override
	public void updateCourseInfo(Connection conn, String aName, int cID, String cName, short cSerial, float cCredit, 
			                     String pWeek, String pTime, String pClassroom, short tID) throws SQLException {
		Statement statement = conn.createStatement();
		String searchaID = "select aID from academy where aName = " + "'" + aName + "'";
		ResultSet rsaID = statement.executeQuery(searchaID);
		rsaID.next();
		String updateCourseAndProvide = "update course as C, provide as P"
				         + "set C.aID = " + rsaID.getShort("aID") + ", C.cName = '" + cName +"', C.cCredit = " + cCredit + ", P.pWeek = '" 
				                          + pWeek + "', P.pTime = '" + pTime + "', P.pClassroom = '" + pClassroom + "', P.tID = " + tID
						 + " where P.cID = " + cID + " and P.cSerial = " + cSerial + " and C.cID = " + cID + " and C.cSerial = " + cSerial;
		statement.executeUpdate(updateCourseAndProvide);
		System.out.println("更新课程: " + updateCourseAndProvide);
		statement.close();
	}
	
	@Override
	public List<Course> getCourseList(Connection conn) throws SQLException {
		List<Course> courseList = new ArrayList<Course>();
		Statement statement = conn.createStatement();
		// System.out.println("Connect Database Ok！！！");
		// 执行查询语句，返回结果集
		String searchCourseAndProvideAndAcademy = "select * from course as C, provide as P, academy as A "
				+ "where C.cID = P.cID and C.cSerial = P.cSerial and A.aID = C.aID order by cID, cSerial";
		ResultSet rs = statement.executeQuery(searchCourseAndProvideAndAcademy);
		System.out.println("查询全部课程: " + searchCourseAndProvideAndAcademy);
		Course course = new Course();
		while (rs.next()) {
			course.setcID(rs.getInt("cID"));
			course.setcSerial(rs.getShort("cSerial"));
			course.setaName(rs.getString("aName"));
			course.setcName(rs.getString("cName"));
			course.setcCredit(rs.getFloat("cCredit"));
			course.setpClassroom(rs.getString("pClassroom"));
			course.setpTime(rs.getString("pTime"));
			course.setpWeek(rs.getString("pWeek"));
			course.settID(rs.getShort("tID"));

			courseList.add(course);
		}
		statement.close();
		return courseList;
	}

	@Override
	public Course getCourseByIDandSerial(Connection conn, int cID, short cSerial) throws SQLException {
		Course course = new Course();
		Statement statement = conn.createStatement();
		String searchCourseAndProvideAndAcademy = "select * from course as C, provide as P, academy as A "
                + "where C.cID = P.cID and C.cSerial = P.cSerial and A.aID = C.aID and C.cID = " + cID + " and C.cSerial = " + cSerial 
                + " order by cID, cSerial";
		System.out.println("查询cID=" + cID +"且cSerial="+ cSerial + "的课程: " + searchCourseAndProvideAndAcademy);
		ResultSet rs = statement.executeQuery(searchCourseAndProvideAndAcademy);
		rs.next();
		course.setcID(cID);
		course.setcSerial(cSerial);
		course.setaName(rs.getString("aName"));
		course.setcName(rs.getString("cName"));
		course.setcCredit(rs.getFloat("cCredit"));
		course.setpClassroom(rs.getString("pClassroom"));
		course.setpTime(rs.getString("pTime"));
		course.setpWeek(rs.getString("pWeek"));
		course.settID(rs.getShort("tID"));

		statement.close();
		return course;
	}

	@Override
	public List<Course> getCourseByName(Connection conn, String cName) throws SQLException {
		Statement statement = conn.createStatement();
		List<Course> courseList = new ArrayList<Course>();
		String searchCourseAndProvideAndAcademy = "select * from course as C, provide as P, academy as A "
				+ "where C.cID = P.cID and C.cSerial = P.cSerial and A.aID = C.aID and C.cName = '" + cName
				+ "' order by cID, cSerial";
	    System.out.println("查询cName="+ cName + "的课程: " + searchCourseAndProvideAndAcademy);
		ResultSet rs = statement.executeQuery(searchCourseAndProvideAndAcademy);
		Course course = new Course();
		while (rs.next()) {
			course.setcID(rs.getInt("cID"));
			course.setcSerial(rs.getShort("cSerial"));
			course.setaName(rs.getString("aName"));
			course.setcName(cName);
			course.setcCredit(rs.getFloat("cCredit"));
			course.setpClassroom(rs.getString("pClassroom"));
			course.setpTime(rs.getString("pTime"));
			course.setpWeek(rs.getString("pWeek"));
			course.settID(rs.getShort("tID"));
			
			courseList.add(course);
		}
		statement.close();
		return courseList;
	}
}
