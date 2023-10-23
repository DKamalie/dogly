package com.example.application.dao;
import com.example.application.domain.Registration;
import com.vaadin.flow.component.notification.Notification;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterDAO {

  //Testing database code

    private static final String url = "jdbc:sqlite:C:/sqlitestudio-3.3.3 (1)/SQLiteStudio/SQLite database/doglyDB.db";
    public void saveRegistration(Registration registration) throws SQLException {



        try (Connection connection = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO USER (first_name, last_name, email, username, password, register_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, registration.getFirstName());
                statement.setString(2, registration.getLastName());
                statement.setString(3, registration.getEmail());
                statement.setString(4, registration.getUsername());
                statement.setString(5, registration.getPassword());
                statement.setString(6, registration.getRegisterDate().toString());

                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    Notification.show("Registration successful");
                } else {
                    Notification.show("Failed to save registration details");
                }
            }
        }catch (SQLException e){
            Notification.show(e.getMessage());
        }
    }

        public List<Registration> getAllRegistrations() {
            List<Registration> registrations = new ArrayList<>();

            try (Connection connection = DriverManager.getConnection(url);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM USER")) {

                while (resultSet.next()) {
                    Registration registration = new Registration();
                    registration.setUserId(resultSet.getString("user_id"));
                    registration.setFirstName(resultSet.getString("first_name"));
                    registration.setLastName(resultSet.getString("last_name"));
                    registration.setEmail(resultSet.getString("email"));
                    registration.setUsername(resultSet.getString("username"));
                    registration.setPassword(resultSet.getString("password"));

                    registrations.add(registration);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return registrations;
        }

    public boolean checkEmailExists(String email) {
        try (Connection connection = DriverManager.getConnection(url)) {
            String emailCheckQuery = "SELECT COUNT(*) FROM USER WHERE email = ?";
            try (PreparedStatement emailCheckStatement = connection.prepareStatement(emailCheckQuery)) {
                emailCheckStatement.setString(1, email);
                try (ResultSet emailCheckResult = emailCheckStatement.executeQuery()) {
                    return emailCheckResult.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            Notification.show(e.getMessage());
        }
        return false;
    }

    public boolean checkUsernameExists(String username) {
        try (Connection connection = DriverManager.getConnection(url)) {
            String usernameCheckQuery = "SELECT COUNT(*) FROM USER WHERE username = ?";
            try (PreparedStatement usernameCheckStatement = connection.prepareStatement(usernameCheckQuery)) {
                usernameCheckStatement.setString(1, username);
                try (ResultSet usernameCheckResult = usernameCheckStatement.executeQuery()) {
                    return usernameCheckResult.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            Notification.show(e.getMessage());
        }
        return false;
    }

    public boolean checkPasswordExists(String password) {
        try (Connection connection = DriverManager.getConnection(url)) {
            String passwordCheckQuery = "SELECT COUNT(*) FROM USER WHERE password = ?";
            try (PreparedStatement passwordCheckStatement = connection.prepareStatement(passwordCheckQuery)) {
                passwordCheckStatement.setString(1, password);
                try (ResultSet passwordCheckResult = passwordCheckStatement.executeQuery()) {
                    return passwordCheckResult.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            Notification.show(e.getMessage());
        }
        return false;
    }

    public boolean validateLogin(String usernameOrEmail, String password) {
        try (Connection connection = DriverManager.getConnection(url)) {
            String loginCheckQuery = "SELECT COUNT(*) FROM USER WHERE (username = ? OR email = ?) AND password = ?";
            try (PreparedStatement loginCheckStatement = connection.prepareStatement(loginCheckQuery)) {
                loginCheckStatement.setString(1, usernameOrEmail);
                loginCheckStatement.setString(2, usernameOrEmail);
                loginCheckStatement.setString(3, password);
                try (ResultSet loginCheckResult = loginCheckStatement.executeQuery()) {
                    return loginCheckResult.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            Notification.show(e.getMessage());
        }
        return false;
    }

    public boolean validateEmail(String email) {
        try (Connection connection = DriverManager.getConnection(url)) {
            String emailQuery = "SELECT COUNT(*) FROM USER WHERE email = ?";
            try (PreparedStatement emailStatement = connection.prepareStatement(emailQuery)) {
                emailStatement.setString(1, email);
                try (ResultSet loginCheckResult = emailStatement.executeQuery()) {
                    return loginCheckResult.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            Notification.show(e.getMessage());
        }
        return false;
    }

    public boolean updatePassword(String email, String newPassword) {
        try (Connection connection = DriverManager.getConnection(url)) {
            String updateQuery = "UPDATE USER SET password = ? WHERE email = ?";



            try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
                statement.setString(1, newPassword);
                statement.setString(2, email);

                int rowsAffected = statement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            Notification.show(e.getMessage());
        }
        return false;
    }

    }

