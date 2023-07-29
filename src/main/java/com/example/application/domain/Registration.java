package com.example.application.domain;

import java.time.LocalDate;

public class Registration {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private LocalDate registerDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegisterDate() {
        LocalDate registerDate = LocalDate.now();
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "User Id='" + userId + '\'' +
                ", First name='" + firstName + '\'' +
                ", Last name='" + lastName + '\'' +
                ", Email='" + email + '\'' +
                ", Username='" + username + '\'' +
                ", Password='" + password + '\'' +
                ", Register date=" + registerDate +
                '}';
    }
}
