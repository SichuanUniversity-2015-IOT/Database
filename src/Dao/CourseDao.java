package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dao.CourseList.Course;;

public interface CourseDao {
	//增--------------------------------
	public void insertCourse(Connection conn, String aName, int cID, String cName, short cSerial, 
			                 float cCredit, String pWeek, String pTime, String pClassroom, short tID) throws SQLException; 
	//删yes
	public List<Course> deleteCourse(Connection conn, int cID, short cSerial) throws SQLException;  //删除指定课程号和课序号的课程
	//改
	public void updateCourseInfo(Connection conn, String aName, int cID, String cName, short cSerial, 
			                     float cCredit, String pWeek, String pTime, String pClassroom, short tID) throws SQLException; 
	//查
	public List<Course> getCourseList(Connection conn) throws SQLException; // 查询全部课程
	public Course getCourseByIDandSerial(Connection conn, int id, short serial) throws SQLException; // 查询指定课程号和课序号的课程
	public List<Course> getCourseByName(Connection conn, String cName) throws SQLException; // 查询指定课程名的课程
}
