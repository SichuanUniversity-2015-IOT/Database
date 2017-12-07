package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dao.UserData.Student;

public interface StudentUser {
	
	public UserData getUserData(Connection conn) throws SQLException;
	public Student getStudent(Connection conn, int sID) throws SQLException;
	public void updateStudent(Connection conn, int sID, Student student) throws SQLException;
	public void deleteStudent(Connection conn, int sID) throws SQLException;
	public void addStudent(Connection conn, Student student) throws SQLException;
	public List<Student> searchStudent(Connection conn, String sName) throws SQLException;

}
