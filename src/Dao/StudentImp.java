package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.UserData.Student;
import Dao.UserData.Teacher;

public class StudentImp implements StudentUser {
	
	@Override
	public Student getStudent(Connection conn, int sID) throws SQLException {
		Student student = new Student();
		Statement statement = conn.createStatement();
		String sql = "select * from student where sID = " + sID;
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		
		student.setaID(rs.getInt("aID"));
		student.setsID(rs.getInt("sID"));
		student.setsName(rs.getString("sName"));
		student.setAVG(rs.getFloat("AVG"));
		student.setsPhone(rs.getString("sPhone"));
		student.setsEmail(rs.getString("sEmail"));
		
		statement.close();
		return student;
	}

	
	@Override
	public void updateStudent(Connection conn, int sID, Student student) throws SQLException {

		int aID = student.getaID();		
		String sName = student.getsName();
		float AVG = student.getAVG();
		String sPhone = student.getsPhone();
		String sEmail = student.getsEmail();
		
		
		Statement statement = conn.createStatement();
		String sql = "Update student set aID = "+ aID +", sName = '" + sName + "', sEmail = '" +sEmail+ "', AVG = '" + AVG 
				 + "', sPhone = " + sPhone
						+ "'"
						+ "WHERE sID = "+ sID;
		System.out.println("构造出来的sql语句是：" + sql);
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
		ResultSet rs2;
		while (rs.next()) {
			Student student = new Student();
    		student.setsID(rs.getInt("sID"));
    		student.setaID(rs.getInt("aID"));
    		student.setsName(rs.getString("sName"));
    		student.setAVG(rs.getFloat("AVG"));
    		student.setsPhone(rs.getString("sPhone"));
    		student.setsEmail(rs.getString("sEmail"));
    		
    		String sql2 = "select maName, miName from major, minor where sID=" + student.getsID();
    		rs2 = statement.executeQuery(sql2);
    		student.setsMajor(rs2.getString("maName"));
    		student.setsMinor(rs2.getString("miName"));
    		studentList.add(student);
		}
		statement.close();
		return studentList;
	}
	
	@Override
	public void deleteStudent(Connection conn, int sID) throws SQLException {
		
		Statement statement = conn.createStatement();
		String sql = "delete from student where sID = " + sID;
		statement.executeUpdate(sql);
		System.out.println("删除sID " + sID + "成功。");
		statement.close();
		
	}
	
	@Override
	public void addStudent(Connection conn, Student student) throws SQLException {
		
		int sID = student.getsID();
		int aID = student.getaID();
		String sName = student.getsName();
		float AVG = student.getAVG();
		String sPhone = student.getsPhone();
		String sEmail = student.getsEmail();
		String major = student.getsMajor();
		String minor = student.getsMinor();
		String sql;
		
		Statement statement = conn.createStatement();
		sql = "insert into student(sID, aID, sName, AVG, sPhone, sEmail) values(" + sID +", "
				+ aID + ", '" + sName + "','" + AVG + "', '" + sPhone + "', '" + sEmail + "')";
		statement.executeUpdate(sql);
		System.out.println(sql);
		sql = "insert into major(sID, aID, maName) values(" + sID + ", " + aID + ", '" + major + "')";
		statement.executeUpdate(sql);
		System.out.println(sql);
		sql = "insert into minor(sID, aID, miName) values(" + sID + ", " + aID + ", '" + minor + "')";
		statement.executeUpdate(sql);
		System.out.println(sql);
		
		statement.close();
		
	}
	
	@Override
	public UserData getUserData(Connection conn) throws SQLException {
		UserData userData = new UserData();
		List<Student> studentList = new ArrayList<Student>();
		Statement statement = conn.createStatement();
		String sql = "select * from student";
		System.out.println("查询学生的sql语句: "+ sql);
		ResultSet rs = statement.executeQuery(sql);
		
		rs = statement.executeQuery(sql);
		while(rs.next()){
			Student student = new Student();
			student.setsID(rs.getInt("sID"));
			student.setaID(rs.getInt("aID"));
			student.setsName(rs.getString("sName"));
			student.setAVG(rs.getFloat("AVG"));
			student.setsPhone(rs.getString("sPhone"));
			student.setsEmail(rs.getString("sEmail"));
			
			studentList.add(student);
		}
		userData.setStudentList(studentList);
				
		return userData;
	}
	
}
