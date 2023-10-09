package com.example.application.dao;

import com.example.application.domain.Registration;
import com.example.application.domain.UserProfile;
import com.vaadin.flow.component.notification.Notification;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserProfileDAO {
    public static final String URL = "jdbc:sqlite:C:/Users/TLC11/Desktop/Final year/Project 3/doglyDB.db";
        public void saveUserProfile(UserProfile userProfile) throws SQLException {

            try (Connection connection = DriverManager.getConnection(
                    URL)) {
                String sql = "INSERT INTO UserProfile (userprofileID, userID, locationID, name, age, description, profilePhoto) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, userProfile.getUserprofileID());
                    statement.setString(2, userProfile.getUserID());
                    statement.setString(3, userProfile.getLocationID());
                    statement.setString(4, userProfile.getName());
                    statement.setString(5, userProfile.getAge());
                    statement.setString(6, userProfile.getDescription());
                    statement.setBlob(7, (Blob) userProfile.getProfilePhoto());

                    int rowsAffected = statement.executeUpdate();

                    if (rowsAffected > 0) {
                        Notification.show("UserProfile Added successful");
                    } else {
                        Notification.show("Failed to save UserProfile details");
                    }
                }
            }catch (SQLException e){
                Notification.show(e.getMessage());
            }
        }

        public List<UserProfile> getAllUserProfile() {
            List<UserProfile> userProfileList = new ArrayList<>();

            try (Connection connection = DriverManager.getConnection(
                    URL);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM UserProfile")) {

                while (resultSet.next()) {
                    UserProfile userProfile = new UserProfile();
                    userProfile.setUserprofileID(resultSet.getString(""));
                    userProfile.setUserID(resultSet.getString(""));
                    userProfile.setLocationID(resultSet.getString(""));
                    userProfile.setName(resultSet.getString(""));
                    userProfile.setAge(resultSet.getString(""));
                    userProfile.setDescription(resultSet.getString(""));
                    userProfile.setProfilePhoto(resultSet.getBlob(""));

                    userProfileList.add(userProfile);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return userProfileList;
        }


}
