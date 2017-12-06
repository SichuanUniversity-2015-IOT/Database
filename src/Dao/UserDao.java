package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dao.UserData.Student;
import Dao.UserData.Teacher;




public interface UserDao {
	public UserData getUserData(Connection conn) throws SQLException;
	public Student getStudent(Connection conn, int sID) throws SQLException;
	public Teacher getTeacher(Connection conn, int tID) throws SQLException;
	public void updateStudent(Connection conn, int sID, Student student) throws SQLException;
	public void updateTeacher(Connection conn, int tID, Teacher teacher) throws SQLException;
	public List<Student> searchStudent(Connection conn, String sName) throws SQLException;
	public List<Teacher> searchTeacher(Connection conn, String tName) throws SQLException;
}
