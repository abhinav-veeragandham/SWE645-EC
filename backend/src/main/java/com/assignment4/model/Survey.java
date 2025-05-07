// TEAM MEMBERS:

// Abhinav Veeragandham - G01515455
// Pranav Vangavety - G01511443
// Charan Sri Sai Devalla - G01504177
// Bhogeswara Pathakamudi - G01507114
// Durga Shankar Kondaveeti - G01510533
// Chinmaya Raz Vaiisshnav Maddi - G01504185
// Naga Venkata Sai Chennu - G01514409
// Abhiram Kolisetty - G01506075

//This file represents table in the database, and each field in the class becomes a column.

package com.assignment4.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    private LocalDate surveyDate;

    @ElementCollection
    private List<String> likedMost;

    private String interestSource;
    private String recommendation;
    private String comments;


    public Survey() {}

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(LocalDate surveyDate) {
        this.surveyDate = surveyDate;
    }

    public List<String> getLikedMost() {
        return likedMost;
    }

    public void setLikedMost(List<String> likedMost) {
        this.likedMost = likedMost;
    }

    public String getInterestSource() {
        return interestSource;
    }

    public void setInterestSource(String interestSource) {
        this.interestSource = interestSource;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
