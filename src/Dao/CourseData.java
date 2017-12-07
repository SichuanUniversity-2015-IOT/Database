package Dao;

import java.util.List;

public class CourseData {
	private List<Course> courseList;
	
	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseData(List<Course> courseData) {
		this.courseList = courseData;
	}
	
	public static class Course {

		private int cID;
		private int aID;
		private String tName;
		private String cName;
		private String classroom;
		private String date;
		private boolean filled = false;
		
		public Course(){};
		public Course(int cID, int aID, String tName, String cName, String classroom, String date){
			this.cID = cID;
			this.aID = aID;
			this.tName = tName;
			this.cName = cName;
			this.classroom = classroom;
			this.date = date;
		}
		
		public int getcID() {
			return cID;
		}
		public void setcID(int cID) {
			this.cID = cID;
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
		public String getcName() {
			return cName;
		}
		public void setcName(String cName) {
			this.cName = cName;
		}
		public String getClassroom() {
			return classroom;
		}
		public void setClassroom(String classroom) {
			this.classroom = classroom;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public boolean isfilled() {
			return filled;
		}
		public void setfilled(String status) {
			if(status.equals("PASS"))
				filled = true;	
		}

	}
}
