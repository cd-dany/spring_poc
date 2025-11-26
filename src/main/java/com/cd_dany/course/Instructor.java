package com.cd_dany.course;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Instructor {
    @JsonProperty("ContactInformation") 
    private ContactInformation contactInformation;

    @JsonProperty("OfficeInformation")
    private OfficeInformation officeInformation;

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation ci) {
        this.contactInformation = ci;
    }

    public OfficeInformation getOfficeInformation() {
        return officeInformation;
    }

    public void setOfficeInformation(OfficeInformation oi) {
        this.officeInformation = oi;
    }
}