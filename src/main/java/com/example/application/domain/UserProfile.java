package com.example.application.domain;

import javax.swing.*;
import java.sql.Blob;

public class UserProfile {
    public String userprofileID;
    public String userID;
    public String locationID;
    public String name;
    public String age;
    public String description;
    public Blob profilePhoto;

    public UserProfile(String userprofileID,
                       String userID,
                       String locationID,
                       String name,
                       String age,
                       String description,
                       Blob profilePhoto
    ) {
        this.userprofileID = userprofileID;
        this.userID = userID;
        this.locationID = locationID;
        this.name = name;
        this.age = age;
        this.description = description;
        this.profilePhoto = profilePhoto;
    }

    public UserProfile(){

    }
    public String getUserprofileID() {
        return userprofileID;
    }

    public void setUserprofileID(String userprofileID) {
        this.userprofileID = userprofileID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blob getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(Blob profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "userprofileID='" + userprofileID + '\'' +
                ", userID='" + userID + '\'' +
                ", locationID='" + locationID + '\'' +
                ", Name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", description='" + description + '\'' +
                ", profilePhoto=" + profilePhoto +
                '}';
    }
}
