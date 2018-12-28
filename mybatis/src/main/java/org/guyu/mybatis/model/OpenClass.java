package org.guyu.mybatis.model;

public class OpenClass {
    private Long id;
    private Long sdt;
    private String classroom;
    private String introduce;
    private String imgSrc;
    private String imgSrcPhone;
    private String openclassType;
    private String lessonTitle;
    private Long lessonId;
    private Long courseId;
    private Long teacherId;

    public OpenClass() {}

    private OpenClass(Builder builder) {
        setId(builder.id);
        setSdt(builder.sdt);
        setClassroom(builder.classRoom);
        setIntroduce(builder.introduce);
        setImgSrc(builder.imgSrc);
        setImgSrcPhone(builder.imgSrcPhone);
        setOpenclassType(builder.openclassType);
        setLessonTitle(builder.lessonTitle);
        setLessonId(builder.lessonId);
        setCourseId(builder.courseId);
        setTeacherId(builder.teacherId);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSdt() {
        return sdt;
    }

    public void setSdt(Long sdt) {
        this.sdt = sdt;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getImgSrcPhone() {
        return imgSrcPhone;
    }

    public void setImgSrcPhone(String imgSrcPhone) {
        this.imgSrcPhone = imgSrcPhone;
    }

    public String getOpenclassType() {
        return openclassType;
    }

    public void setOpenclassType(String openclassType) {
        this.openclassType = openclassType;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public static final class Builder {
        private Long id;
        private Long sdt;
        private String classRoom;
        private String introduce;
        private String imgSrc;
        private String imgSrcPhone;
        private String openclassType;
        private String lessonTitle;
        private Long lessonId;
        private Long courseId;
        private Long teacherId;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder sdt(Long sdt) {
            this.sdt = sdt;
            return this;
        }

        public Builder classRoom(String classRoom) {
            this.classRoom = classRoom;
            return this;
        }

        public Builder introduce(String introduce) {
            this.introduce = introduce;
            return this;
        }

        public Builder imgSrc(String imgSrc) {
            this.imgSrc = imgSrc;
            return this;
        }

        public Builder imgSrcPhone(String imgSrcPhone) {
            this.imgSrcPhone = imgSrcPhone;
            return this;
        }

        public Builder openclassType(String openclassType) {
            this.openclassType = openclassType;
            return this;
        }

        public Builder lessonTitle(String lessonTitle) {
            this.lessonTitle = lessonTitle;
            return this;
        }

        public Builder lessonId(Long lessonId) {
            this.lessonId = lessonId;
            return this;
        }

        public Builder courseId(Long courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder teacherId(Long teacherId) {
            this.teacherId = teacherId;
            return this;
        }

        public OpenClass build() {
            return new OpenClass(this);
        }
    }
}
