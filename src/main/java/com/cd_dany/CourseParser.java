package com.cd_dany;

import java.io.File;
import java.time.LocalDateTime;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Entry;
import com.calendarfx.model.Interval;
import com.cd_dany.course.Course;
import com.cd_dany.course.CourseWrapper;
import com.cd_dany.course.Schedule;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CourseParser {
    
    private CourseParser(){
    }

    public static Calendar getCalendar(String path)throws Exception{

        //JSON Mapper 
        ObjectMapper mapper = new ObjectMapper();

        //We use the Mapper along with JSON property tags to fully map the JSON file and represent it as a Java Obejct or in this case the course Wrapper
        CourseWrapper wrapper = mapper.readValue(new File("src/main/resources/course.json"), CourseWrapper.class);

        //Get the course from the wrapper
        Course course = wrapper.getCourse();

        /*
         * CalendarFX JavaDocs, find Entry Class for context https://dlsc.com/wp-content/html/calendarfx/apidocs/index.html
         */
        Calendar calendar = new Calendar(course.getCourseTitle() + " " + course.getCourseCode());

        /*
         * LocalDateTime JavaDocs https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/LocalDateTime.html
         * CalendarFX JavaDocs, find Interval Class for context https://dlsc.com/wp-content/html/calendarfx/apidocs/com/calendarfx/model/Interval.html
         * This for-each loop loads all the class times to the calendar
         */
        for (Schedule s : course.getCourseSchedule()) {
            LocalDateTime st = LocalDateTime.parse(s.getDate() + "T" + s.getStartTime());
            LocalDateTime et = LocalDateTime.parse(s.getDate() + "T" + s.getEndTime());
            Interval interval = new Interval(st,et);//Interval(LocalDateTime startDateTime, LocalDateTime endDateTime)

            Entry entry = new Entry<>(s.getTopic());
            entry.setLocation(course.getInstructor().getOfficeInformation().getOfficeLocation());
            entry.setInterval(interval);
            calendar.addEntry(entry);
        }
        /*
         * LocalDateTime JavaDocs https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/LocalDateTime.html
         * CalendarFX JavaDocs, find Interval Class for context https://dlsc.com/wp-content/html/calendarfx/apidocs/com/calendarfx/model/Interval.html
         * This for-each loop loads all the class times to the calendar
         */
        return calendar;
    }
    
}
