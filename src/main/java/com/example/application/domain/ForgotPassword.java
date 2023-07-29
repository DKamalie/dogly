

package com.example.application.domain;

/*
ForgotPassword.java
Author: Tamryn Lisa Lewin (219211981)
Date: 20 May 2023
 */

public class ForgotPassword {
    private String email;

    private ForgotPassword() {

    }
    private ForgotPassword(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ForgotPassword{" +
                "email='" + email + '\'' +
                '}';
    }

    public static ForgotPassword create(String email) {
        return new ForgotPassword(email);
    }
}