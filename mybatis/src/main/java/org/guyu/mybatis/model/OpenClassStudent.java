package org.guyu.mybatis.model;

public class OpenClassStudent {
    private Long studentId;

    private Long classId;

    public OpenClassStudent() {}

    private OpenClassStudent(Builder builder) {
        setStudent_id(builder.studentId);
        setClass_id(builder.classId);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getStudent_id() {
        return studentId;
    }

    public void setStudent_id(Long studentId) {
        this.studentId = studentId;
    }

    public Long getClass_id() {
        return classId;
    }

    public void setClass_id(Long classId) {
        this.classId = classId;
    }

    public static final class Builder {
        private Long studentId;
        private Long classId;

        private Builder() {
        }

        public Builder studentId(Long studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder classId(Long classId) {
            this.classId = classId;
            return this;
        }

        public OpenClassStudent build() {
            return new OpenClassStudent(this);
        }
    }
}
