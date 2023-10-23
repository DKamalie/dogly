package com.example.application.domain;

/*
ResetPassword.java
Author: Tamryn Lisa Lewin (219211981)
Date: 20 May 2023
 */

public class ResetPassword {
    private String newPassword;
    private String confirmNewPassword;
    private ResetPassword() {}

    private ResetPassword(String newPassword, String confirmNewPassword) {
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    @Override
    public String toString() {
        return "ResetPassword{" +
                "newPassword='" + newPassword + '\'' +
                ", confirmNewPassword='" + confirmNewPassword + '\'' +
                '}';
    }

    public static ResetPassword create(String newPassword, String confirmNewPassword) {
        return new ResetPassword(newPassword, confirmNewPassword);
    }

}
