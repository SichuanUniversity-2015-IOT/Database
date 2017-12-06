package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.CourseData.Course;
import Dao.UserData.Student;
import Dao.UserData.Teacher;

public class UserDaoImp implements UserDao{

	@Override
	public UserData getUserData(Connection conn) throws SQLException {
		UserData userData = new UserData();
		List<Student> studentList = new ArrayList<Student>();
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
		
		
		sql = "select * from student";
		System.out.println("查询学生的sql语句: "+ sql);
		
		rs = statement.executeQuery(sql);
		while(rs.next()){
			Student student = new Student();
			student.setaID(rs.getInt("aID"));
			student.setsEmail(rs.getString("sEmail"));
			student.setsID(rs.getInt("sID"));
			student.setsName(rs.getString("sName"));
			student.setsMajor(rs.getString("sMajor"));
			
			studentList.add(student);
		}
		userData.setStudentList(studentList);
		
		return userData;
	}

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
