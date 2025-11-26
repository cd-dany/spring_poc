package com.cd_dany.course;

import com.fasterxml.jackson.annotation.JsonProperty;

//Course Wrapper course just returns the course
public class CourseWrapper {

    @JsonProperty("course")
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}