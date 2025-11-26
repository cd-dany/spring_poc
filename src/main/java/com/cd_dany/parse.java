/*
 * Note: This Parse java class is just a test to see how JSON parses into Java Objects that we can use
 * It uses the Jackson Library to get an object mapper that maps our json file.
 * 
 * https://www.baeldung.com/jackson-object-mapper-tutorial
 * 
 * 
 */


package com.cd_dany;

import com.cd_dany.course.Course;
import com.cd_dany.course.CourseWrapper;
import com.cd_dany.course.OfficeTime;
import com.cd_dany.course.Schedule;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;



public class parse {
    public static void main(String[] args) throws Exception {
        //Jackson JSON Mapper
        ObjectMapper mapper = new ObjectMapper();


        //All classes "Wrapped" inside this class
        CourseWrapper wrapper = mapper.readValue(new File("src/main/resources/course.json"), CourseWrapper.class);

        //Get Course from wrapper classs
        Course course = wrapper.getCourse();

        //Print out any information
        System.out.println("Course: " + course.getCourseTitle() + " " + course.getCourseCode() + "");
        System.out.println("Semester: " + course.getCourseSemester() + " " + course.getCourseYear());
        System.out.println("Instructor Email: " + course.getInstructor().getContactInformation().getEmail());
        System.out.println("Office: " + course.getInstructor().getOfficeInformation().getOfficeLocation());
        System.out.println("\nOffice Hours:");

        //Office Time is a JSON array, we have to loop through it (getOfficeTimes returns a linked ist)
        for (OfficeTime ot : course.getInstructor().getOfficeInformation().getOfficeTimes()) {
            System.out.println("  " + ot.getDayOfTheWeek() + ": " + ot.getStartTime() + " - " + ot.getEndTime());
        }

        //Course Shedule is a JSON Array As well
        System.out.println("\nCourse Schedule:");
        for (Schedule s : course.getCourseSchedule()) {
            System.out.println("  " + s.getDate() + " (" + s.getStartTime() + "-" + s.getEndTime() + "): " + s.getTopic());
        }
    }
}

