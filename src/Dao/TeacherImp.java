package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.UserData.Teacher;

public class TeacherImp implements TeacherUser {
	
	@Override
	public Teacher getTeacher(Connection conn, int tID) throws SQLException {
		Teacher teacher = new Teacher();
		Statement statement = conn.createStatement();
		String sql = "select * from teacher where tID = " + tID;
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		
		teacher.setaID(rs.getInt("aID"));
		teacher.settField((rs.getString("tField")));
		teacher.settEmail(rs.getString("tEmail"));
		teacher.settID(rs.getInt("tID"));
		teacher.settName(rs.getString("tName"));
		
		statement.close();
		return teacher;
	}
	
	@Override
	public void updateTeacher(Connection conn, int tID, Teacher teacher) throws SQLException {
		int aID = teacher.getaID();
		String tEmail = teacher.gettEmail();
		String tField = teacher.gettField();
		String tName = teacher.gettName();
		
		Statement statement = conn.createStatement();
		String sql = "Update teacher set aID = "+ aID +", "
				+ "tName = '"+ tName +"', tEmail = '"+tEmail+"', "
						+ "tField = '"+ tField +"'"
						+ "WHERE tID = "+ tID;
		System.out.println("构造出来的sql语句是："+sql);
		statement.executeUpdate(sql);
	}

	@Override
	public List<Teacher> searchTeacher(Connection conn, String tName) throws SQLException {
		Statement statement = conn.createStatement();
		List<Teacher> teacherList = new ArrayList<Teacher>();
		//System.out.println("Connect Database Ok！！！");
		//执行查询语句，返回结果集
		String sql = "select * from teacher where tName='"+tName+"'";
		//System.out.println("构造出来的sql语句是："+sql);
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Teacher teacher = new Teacher();
    		teacher.setaID(rs.getInt("aID"));
    		teacher.settEmail(rs.getString("tEmail"));
    		teacher.settField(rs.getString("tField"));
    		teacher.settID(rs.getInt("tID"));
    		teacher.settName(rs.getString("tName"));
    		teacherList.add(teacher);
		}
		statement.close();
		return teacherList;
	}
	
}
