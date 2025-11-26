package com.cd_dany.course;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactInformation {

    @JsonProperty("email")
    private String email; 
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("name")
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
}