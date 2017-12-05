package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dao.UserData.Teacher;

public interface TeacherUser {
	
	//public UserData getUserData(Connection conn) throws SQLException;
	public Teacher getTeacher(Connection conn, int tID) throws SQLException;
	public void updateTeacher(Connection conn, int tID, Teacher teacher) throws SQLException;
	public List<Teacher> searchTeacher(Connection conn, String tName) throws SQLException;

}
