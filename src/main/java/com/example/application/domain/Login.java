

package com.example.application.domain;


/*
Login.java
Author: Tamryn Lisa Lewin (219211981)
Date: 20 May 2023
 */

    public class Login {
        private String usernameOrEmail;
        private String password;

        private Login() {}

        private Login(String usernameOrEmail, String password) {
            this.usernameOrEmail = usernameOrEmail;
            this.password = password;
        }

        public String getUsernameOrEmail() {
            return usernameOrEmail;
        }


        public String getPassword() {
            return password;
        }

        public void setUsernameOrEmail(String username) {
            this.usernameOrEmail = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "Login{" +
                    "username='" + usernameOrEmail + '\'' + /*
                ", email='" + email + '\'' +*/
                    ", password='" + password + '\'' +
                    '}';
        }

        public static Login create(String usernameOrEmail, String password) {
            return new Login(usernameOrEmail, password);
        }
    }




