package com.cd_dany.course;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedList;

public class Course {
    @JsonProperty("Instructor") 
    private Instructor instructor;

    @JsonProperty("course_code")
    private String courseCode;

    @JsonProperty("course_title")
    private String courseTitle;

    @JsonProperty("course_year")
    private String courseYear;

    @JsonProperty("course_semester")
    private String courseSemester;

    @JsonProperty("course_schedule")
    private LinkedList<Schedule> courseSchedule;

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public String getCourseSemester() {
        return courseSemester;
    }

    public void setCourseSemester(String courseSemester) {
        this.courseSemester = courseSemester;
    }

    public LinkedList<Schedule> getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(LinkedList<Schedule> courseSchedule) {
        this.courseSchedule = courseSchedule;
    }
}