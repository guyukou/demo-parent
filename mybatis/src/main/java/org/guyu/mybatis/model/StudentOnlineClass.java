package org.guyu.mybatis.model;

/**
 * Created by caojianhua 2017年7月13日 下午1:44:55
 */
public class StudentOnlineClass extends Course{
	@Override
	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getClassType() {
		return classType;
	}

	public void setClassType(Integer classType) {
		this.classType = classType;
	}

	public Long getScheduledDateTime() {
		return scheduledDateTime;
	}

	public void setScheduledDateTime(Long scheduledDateTime) {
		this.scheduledDateTime = scheduledDateTime;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public boolean isOpenClass() {
		return isOpenClass;
	}

	public void setOpenClass(boolean openClass) {
		isOpenClass = openClass;
	}

	private Long studentId;
	private Long classId;
	private String status;
	private Integer classType;
	private Long scheduledDateTime;
	private String classroom;
	private Long lessonId;
	private Long courseId;
	private Long createTime;
	private Long updateTime;
	private Long version;
	private boolean isOpenClass;


	public Integer getBookType() {
		return bookType;
	}

	public void setBookType(Integer bookType) {
		this.bookType = bookType;
	}

	private Integer bookType;
	
	@Override
	public long getCourseScheduledTime() {
		return this.scheduledDateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classId == null) ? 0 : classId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentOnlineClass other = (StudentOnlineClass) obj;
		if (classId == null) {
			if (other.classId != null)
				return false;
		} else if (!classId.equals(other.classId))
			return false;
		return true;
	}
	
	
}
