package com.jpaapplication.connectingjpa.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;


public class PatientDto implements Serializable {
    private static final long serialVersionUID = 1L;


    @Size(max = 10,message = "Patients Name should be Less than 10")
    @NotBlank
    private String firstName;

    @Size(max = 10,message = "Patients Name should be Less than 10")
    private String lastName;

    @Size(max = 30,message = "Patients Address should be Less than 30")
    private String address;

    @Size(max = 20,message = "Patients City Name should be Less than 20")
    private String city;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
