package org.guyu.mybatis;

import org.guyu.mybatis.mapper.OpenClassMapper;
import org.guyu.mybatis.mapper.OpenClassStudentMapper;
import org.guyu.mybatis.mapper.StudentOnlineClassMapper;
import org.guyu.mybatis.mapper.TeacherOnlineClassMapper;
import org.guyu.mybatis.model.OpenClass;
import org.guyu.mybatis.model.OpenClassStudent;
import org.guyu.mybatis.model.StudentOnlineClass;
import org.guyu.mybatis.model.TeacherOnlineClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
@MapperScan(basePackages = "org.guyu.mybatis.mapper")
public class MybatisApplication implements CommandLineRunner {
    private static final long startTime = 1545883200000L;

    @Autowired
    private TeacherOnlineClassMapper teacherOnlineClassMapper;
    @Autowired
    private StudentOnlineClassMapper studentOnlineClassMapper;
    @Autowired
    private OpenClassMapper openClassMapper;
    @Autowired
    private OpenClassStudentMapper openClassStudentMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        initStudent();
//        initTeacher();
        initOpenClass();
    }

    private void initOpenClass() {
        Set<Long> classIds = new HashSet<>();
        for (int m = 0; m < 30; m++) {
            long time = startTime + 30 * 60 * 1000 * (m + 1);
            String timeDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
            int j = 0;
            List<OpenClass> inserts = new ArrayList<>();
            Random random = new Random();
            Date date = new Date();
            for (int i = 0; i < 100; i++) {
                j++;
                OpenClass openclass = new OpenClass();
                long classId = (i + m * 25000);
                classIds.add(classId);
                openclass.setId(classId);
                openclass.setClassroom("abasdjflkajsdlfkeiwo");
                openclass.setCourseId((long) (i + 20000));
                openclass.setImgSrc("asdf");
                openclass.setImgSrcPhone("1234");
                openclass.setIntroduce("asdfasdf");
                openclass.setSdt(time);
                openclass.setTeacherId((long) (i + 10000));
                openclass.setOpenclassType("BOOKED");
                openclass.setLessonTitle("teach so");
                openclass.setLessonId((long) (random.nextInt(20000) + 1));
                inserts.add(openclass);
                if (j == 1000) {
                    j = 0;
                    openClassMapper.insertList(inserts);
                    inserts.clear();
                }
            }
            if (!inserts.isEmpty()) {

                openClassMapper.insertList(inserts);
            }
        }
        Random random = new Random();
        for (Long classId : classIds) {
            List<OpenClassStudent> openClassStudents = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                OpenClassStudent openClassStudent = new OpenClassStudent();
                openClassStudent.setClass_id(classId);
                openClassStudent.setStudent_id((long) (i+100));
                openClassStudents.add(openClassStudent);

            }
            openClassStudentMapper.insertList(openClassStudents);
        }

    }

    private void initStudent() {
        for (int m = 0;m<30;m++) {
            long time = startTime + 30 * 60 * 1000 * (m + 1);
            String timeDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
            int j = 0;
            List<StudentOnlineClass> inserts = new ArrayList<>();
            Random random = new Random();
            Date date = new Date();
            for (int i = 0; i < 25000; i++) {
                j++;
                StudentOnlineClass studentOnlineClass = new StudentOnlineClass();


                studentOnlineClass.setBookType(0);
                studentOnlineClass.setClassId((long) (i+m*25000));
                studentOnlineClass.setStatus("BOOKED");
                studentOnlineClass.setClassType(0);
                studentOnlineClass.setScheduledDateTime(time);
                studentOnlineClass.setStudentId((long) (random.nextInt(20000)+1));
                studentOnlineClass.setStudentId((long) (i+10000));
                studentOnlineClass.setCourseId((long) (i+20000));
                studentOnlineClass.setCreateTime(date.getTime());
                studentOnlineClass.setUpdateTime(date.getTime());
                studentOnlineClass.setClassroom("abasdjflkajsdlfkeiwo");
                studentOnlineClass.setVersion(date.getTime());
                inserts.add(studentOnlineClass);
                if (j == 1000) {
                    j = 0;
                    studentOnlineClassMapper.insertList(inserts);
                    inserts.clear();
                }
            }
            if (!inserts.isEmpty()) {

                studentOnlineClassMapper.insertList(inserts);
            }
        }
    }

    private void initTeacher() {
        for (int m = 0;m<30;m++) {
            long time = startTime + 30 * 60 * 1000 * (m + 1);
            String timeDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
            int j = 0;
            List<TeacherOnlineClass> inserts = new ArrayList<>();
            Random random = new Random();
            Date date = new Date();
            for (int i = 0; i < 25000; i++) {
               j++;
                TeacherOnlineClass teacherOnlineClass = new TeacherOnlineClass();
                teacherOnlineClass.setClassId((long) (i+m*25000));
                teacherOnlineClass.setStatus("BOOKED");
                teacherOnlineClass.setClassType(0);
                teacherOnlineClass.setScheduledDateTime(time);
                teacherOnlineClass.setLocalScheduledDateTime(timeDate);
                teacherOnlineClass.setTeacherId((long) (random.nextInt(20000)+1));
                teacherOnlineClass.setStudentId((long) (i+10000));
                teacherOnlineClass.setCourseId((long) (i+20000));
                teacherOnlineClass.setCreateTime(date.getTime());
                teacherOnlineClass.setUpdateTime(date.getTime());
                teacherOnlineClass.setClassroom("abasdjflkajsdlfkeiwo");
                teacherOnlineClass.setVersion(date.getTime());
                inserts.add(teacherOnlineClass);
                if (j == 1000) {
                    j = 0;
                    teacherOnlineClassMapper.insertList(inserts);
                    inserts.clear();
                }
            }
            if (!inserts.isEmpty()) {

                teacherOnlineClassMapper.insertList(inserts);
            }
        }
    }
}

