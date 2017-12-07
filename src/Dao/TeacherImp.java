package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.UserData.Student;
import Dao.UserData.Teacher;

public class TeacherImp implements TeacherUser {
	
	@Override
	public Teacher getTeacher(Connection conn, int tID) throws SQLException {
		Teacher teacher = new Teacher();
		Statement statement = conn.createStatement();
		String sql = "select * from teacher where tID = " + tID;
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		
		teacher.settID(rs.getInt("tID"));
		teacher.setaID(rs.getInt("aID"));
		teacher.settName(rs.getString("tName"));
		teacher.settTitle(rs.getString("tTitle"));
		teacher.settField((rs.getString("tField")));
		teacher.settPhone(rs.getString("tPhone"));
		teacher.settEmail(rs.getString("tEmail"));
				
		statement.close();
		
		return teacher;
	}
	
	@Override
	public void updateTeacher(Connection conn, int tID, Teacher teacher) throws SQLException {
		
		int aID = teacher.getaID();
		String tName = teacher.gettName();
		String tTitle = teacher.gettTitle();
		String tField = teacher.gettField();
		String tPhone = teacher.gettPhone();
		String tEmail = teacher.gettEmail();
		
		Statement statement = conn.createStatement();
		String sql = "Update teacher set aID = "+ aID +", "
				+ "tName = '"+ tName +"', tEmail = '"+tEmail+"', tTitle='"+tTitle+"', tPhone='"+tPhone
						+ "', tField = '"+ tField +"'"
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
    		teacher.settID(rs.getInt("tID"));
    		teacher.setaID(rs.getInt("aID"));
    		teacher.settName(rs.getString("tName"));
    		teacher.settTitle(rs.getString("tTitle"));
    		teacher.settField(rs.getString("tField"));
    		teacher.settPhone(rs.getString("tPhone"));
    		teacher.settEmail(rs.getString("tEmail"));
    		teacherList.add(teacher);
		}
		statement.close();
		return teacherList;
	}
	
	@Override
	public void deleteTeacher(Connection conn, int tID) throws SQLException {
			
		Statement statement = conn.createStatement();
		String sql = "delete from Teacher where sID = " + tID;
		statement.executeUpdate(sql);
		System.out.println("删除tID " + tID + "成功。");
		statement.close();
			
	}
	
	@Override
	public void addTeacher(Connection conn, Teacher teacher) throws SQLException {
		
		int sID = teacher.gettID();
		int aID = teacher.getaID();
		String sName = teacher.gettName();
		String tTitle = teacher.gettTitle();
		String tField = teacher.gettField();
		String sPhone = teacher.gettPhone();
		String sEmail = teacher.gettEmail();
		
		Statement statement = conn.createStatement();
		String sql = "insert into teacher(tID, aID, tName, tTitle, tField, sPhone, sEmail) values(" + sID +", "
				+ aID + ", '" + sName + "','" + tTitle + "', '" + tField + "', '" + sPhone + "', '" + sEmail + "')";
		statement.executeUpdate(sql);
		System.out.println(sql);
		statement.close();
		
	}

	@Override
	public UserData getUserData(Connection conn) throws SQLException {
		UserData userData = new UserData();
		List<Teacher> teacherList = new ArrayList<Teacher>();
		Statement statement = conn.createStatement();
		String sql = "select * from teacher";
		System.out.println("查询教师的sql语句："+sql);
		
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()){
			Teacher teacher = new Teacher();
			teacher.setaID(rs.getInt("aID"));
			teacher.settField((rs.getString("tField")));
			teacher.settEmail(rs.getString("tEmail"));
			teacher.settID(rs.getInt("tID"));
			teacher.settName(rs.getString("tName"));
			
			teacherList.add(teacher);
		}
		userData.setTeacherList(teacherList);
		
		return userData;
	}
	
	
}
