package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dao.CourseData.Course;;

public interface CourseDao {
	public List<Course> getCourseList(Connection conn) throws SQLException;  //查询全部Course
	public Course getCourse(Connection conn, int id) throws SQLException;   //查询指定id的Course
	public List<Course> searchCourses(Connection conn, String cName) throws SQLException;  //查询课程名
	public void updateCourseInfo(Connection conn, int id, Course course) throws SQLException;   //修改对应的课程信息
}
