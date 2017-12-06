package Dao;

import java.util.List;

public class UserData {
	private List<Student> studentList;
	private List<Teacher> teacherList;
	
	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
	public static class Student {
		private int sID;
		private int aID;
		private String sName;
		private String sEmail;
		private String sMajor;
		
		public int getsID() {
			return sID;
		}
		public void setsID(int sID) {
			this.sID = sID;
		}
		
		public int getaID() {
			return aID;
		}
		public void setaID(int aID) {
			this.aID = aID;
		}
		
		public String getsName() {
			return sName;
		}
		public void setsName(String sName) {
			this.sName = sName;
		}
		
		public String getsEmail() {
			return sEmail;
		}
		public void setsEmail(String sEmail) {
			this.sEmail = sEmail;
		}
		
		public String getsMajor() {
			return sMajor;
		}
		public void setsMajor(String sMajor) {
			this.sMajor = sMajor;
		}
	}
	
	public static class Teacher {
		private int tID;
		private int aID;
		private String tName;
		private String tEmail;
		private String tField;
		
		public int gettID() {
			return tID;
		}
		public void settID(int tID) {
			this.tID = tID;
		}
		
		public int getaID() {
			return aID;
		}
		public void setaID(int aID) {
			this.aID = aID;
		}
		
		public String gettName() {
			return tName;
		}
		public void settName(String tName) {
			this.tName = tName;
		}
		
		public String gettEmail() {
			return tEmail;
		}
		public void settEmail(String tEmail) {
			this.tEmail = tEmail;
		}
		
		public String gettField() {
			return tField;
		}
		public void settField(String tField) {
			this.tField = tField;
		}
	}
}
