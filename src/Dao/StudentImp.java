package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.UserData.Student;

public class StudentImp implements StudentUser {
	
	@Override
	public Student getStudent(Connection conn, int sID) throws SQLException {
		Student student = new Student();
		Statement statement = conn.createStatement();
		String sql = "select * from student where sID = " + sID;
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		
		student.setaID(rs.getInt("aID"));
		student.setsEmail(rs.getString("sEmail"));
		student.setsID(rs.getInt("sID"));
		student.setsName(rs.getString("sName"));
		student.setsMajor(rs.getString("sMajor"));
		
		statement.close();
		return student;
	}

	
	@Override
	public void updateStudent(Connection conn, int sID, Student student) throws SQLException {
		int aID = student.getaID();
		String sEmail = student.getsEmail();
		String sMajor = student.getsMajor();
		String sName = student.getsName();
		
		Statement statement = conn.createStatement();
		String sql = "Update student set aID = "+ aID +", "
				+ "sName = '"+ sName +"', sEmail = '"+sEmail+"', "
						+ "sMajor = '"+ sMajor +"'"
						+ "WHERE sID = "+ sID;
		System.out.println("构造出来的sql语句是："+sql);
		statement.executeUpdate(sql);

	}

	
	@Override
	public List<Student> searchStudent(Connection conn, String sName) throws SQLException {
		Statement statement = conn.createStatement();
		List<Student> studentList = new ArrayList<Student>();
		//System.out.println("Connect Database Ok！！！");
		//执行查询语句，返回结果集
		String sql = "select * from student where sName='"+sName+"'";
		//System.out.println("构造出来的sql语句是："+sql);
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Student student = new Student();
    		student.setaID(rs.getInt("aID"));
    		student.setsEmail(rs.getString("sEmail"));
    		student.setsName(rs.getString("sName"));
    		student.setsID(rs.getInt("sID"));
    		student.setsMajor(rs.getString("sMajor"));
    		studentList.add(student);
		}
		statement.close();
		return studentList;
	}	

}
