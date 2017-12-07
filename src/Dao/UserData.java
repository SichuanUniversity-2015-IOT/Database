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
		private String sMinor;
		private float AVG;
		private String sPhone;
		
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
		
		public float getAVG() {
			return AVG;
		}
		public void setAVG(float aVG) {
			AVG = aVG;
		}
		public String getsPhone() {
			return sPhone;
		}
		public void setsPhone(String sPhone) {
			this.sPhone = sPhone;
		}
		public String getsMajor() {
			return sMajor;
		}
		public void setsMajor(String sMajor) {
			this.sMajor = sMajor;
		}
		public String getsMinor() {
			return sMinor;
		}
		public void setsMinor(String sMinor) {
			this.sMinor = sMinor;
		}
	}
	
	public static class Teacher {
		private int tID;
		private int aID;
		private String tName;
		private String tField;
		private String tTitle;
		private String tPhone;
		private String tEmail;
		
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
		public String gettTitle() {
			return tTitle;
		}
		public void settTitle(String tTitle) {
			this.tTitle = tTitle;
		}
		public String gettPhone() {
			return tPhone;
		}
		public void settPhone(String tPhone) {
			this.tPhone = tPhone;
		}
	}
	
}
