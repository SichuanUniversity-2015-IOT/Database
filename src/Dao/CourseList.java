package Dao;

import java.util.List;

public class CourseList {
	private List<Course> courseList;

	public List<Course> getCourseList() {
		return courseList;
	}
	
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public void setCourseData(List<Course> courseData) {
		this.courseList = courseData;
	}

	public static class Course {

		private String aName;
		private int cID;
		private String cName;
		private short cSerial;
		private float cCredit;
		private String pWeek;
		private String pTime;
		private String pClassroom;
		private short tID;

		public Course() {
		};

		public Course(String aName, int cID, String cName, short cSerial, float cCredit, String pWeek, String pTime, String pClassroom, short tID) {
			this.aName = aName;
			this.cID = cID;
			this.cName = cName;
			this.cSerial = cSerial;
			this.cCredit = cCredit;
			this.pWeek = pWeek;
			this.pTime = pTime;
			this.pClassroom = pClassroom;
			this.tID = tID;
		}
		
		public String getaName() {
			return aName;
		}

		public void setaName(String aName) {
			this.aName = aName;
		}
		
		public int getcID() {
			return cID;
		}

		public void setcID(int cID) {
			this.cID = cID;
		}
		
		public String getcName() {
			return cName;
		}

		public void setcName(String cName) {
			this.cName = cName;
		}
		
		public short getcSerial() {
			return cSerial;
		}
		
		public void setcSerial(short cSerial) {
			this.cSerial = cSerial;
		}

		public float getcCredit() {
			return cCredit;
		}

		public void setcCredit(float cCredit) {
			this.cCredit = cCredit;
		}
		
		public String getpWeek() {
			return pWeek;
		}

		public void setpWeek(String pWeek) {
			this.pWeek = pWeek;
		}
		
		public String getpTime() {
			return pTime;
		}

		public void setpTime(String pTime) {
			this.pTime = pTime;
		}
		
		public String getpClassroom() {
			return pClassroom;
		}

		public void setpClassroom(String pClassroom) {
			this.pClassroom = pClassroom;
		}
		
		public Short gettID() {
			return tID;
		}
		
		public void settID(short tID) {
			this.tID = tID;
		}
	}
}
