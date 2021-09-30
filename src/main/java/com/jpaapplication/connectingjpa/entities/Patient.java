package com.jpaapplication.connectingjpa.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Validated
@Table(name="patients")
public class Patient  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patientId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private int zipcode;

    @Column
    private double number;

    @Column
    @Email(message = "Enter Valid Email Address")
    @NotEmpty
    private String email;


    public int getId() {
        return patientId;
    }


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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double Number) {
        this.number = Number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", Firstname='" + firstName + '\'' +
                ", Lastname='" + lastName + '\'' +
                ", Address='" + address + '\'' +
                ", City='" + city + '\'' +
                ", State='" + state + '\'' +
                ", Zipcode=" + zipcode +
                ", Number=" + number +
                ", Email='" + email + '\'' +
                '}';
    }
}
