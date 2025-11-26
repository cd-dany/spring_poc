package com.cd_dany.course;

import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OfficeInformation {
    @JsonProperty("office_location")
    private String officeLocation;

    @JsonProperty("office_times")
    private LinkedList<OfficeTime> officeTimes;

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public LinkedList<OfficeTime> getOfficeTimes() {
        return officeTimes;
    }

    public void setOfficeTimes(LinkedList<OfficeTime> officeTimes) {
        this.officeTimes = officeTimes;
    }
}