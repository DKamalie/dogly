package com.example.application.views.dogprofile;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@PageTitle("DogProfile")
@Route(value = "dogprofile", layout = MainLayout.class)
@RouteAlias(value = "dogprofile", layout = MainLayout.class)
@AnonymousAllowed
public class DogProfileView extends Div {

    protected Image dogImage;
    protected TextField dogNameField;
    protected TextArea bioField;
    protected Button saveButton;

    public DogProfileView() {
        // Create a vertical layout to hold the profile information
        VerticalLayout profileLayout = new VerticalLayout();
        profileLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        // Dog's image
        dogImage = new Image("/images/doggo.jpg", "Dog Image");
        dogImage.getStyle().set("width", "120px");
        dogImage.getStyle().set("height", "120px");
        dogImage.getStyle().set("border-radius", "50%");

        // Editable fields (initially read-only)
        dogNameField = new TextField("Dog's Name");
        dogNameField.setValue("Buddy");
        dogNameField.setReadOnly(true);

        bioField = new TextArea("Bio");
        bioField.setValue("I'm Buddy, a friendly dog who loves to play fetch and go on long walks.");
        bioField.setReadOnly(true);

        // Edit and save buttons
        saveButton = new Button("Save");
        saveButton.getStyle().set("background-color", "green");
        saveButton.getStyle().set("color", "white");
        saveButton.setVisible(false);
        saveButton.addClickListener(event -> saveProfileChanges());

        // Generate a random number of followers for demonstration purposes
        int numberOfFollowers = new Random().nextInt(10000);

        // Follow button and number of followers
        HorizontalLayout followLayout = new HorizontalLayout();
        followLayout.setSpacing(true);
        Button editButton = new Button("Edit");
        editButton.getStyle().set("background-color", "brown");
        editButton.getStyle().set("color", "white");
        editButton.getStyle().set("width", "80px"); // Set the width to match the generated followers
        editButton.addClickListener(event -> enableEditing());
        Div followersDiv = new Div();
        followersDiv.setText(numberOfFollowers + " Followers");
        followersDiv.getStyle().set("font-weight", "bold");
        followersDiv.getStyle().set("background-color", "brown");
        followersDiv.getStyle().set("color", "white");
        followersDiv.getStyle().set("padding", "8px");
        followersDiv.getStyle().set("border-radius", "5px");
        followersDiv.getStyle().set("width", "80px"); // Set the width to match the edit button

        followLayout.add(editButton, followersDiv);

        // Feed images (different images in the feed)
        List<String> feedImageUrls = Arrays.asList(
                "/images/doggo.jpg",
                "/images/doggo.jpg",
                "/images/doggo.jpg",
                "/images/doggo.jpg"
        );

        VerticalLayout feedLayout = new VerticalLayout();
        feedLayout.getStyle().set("margin-top", "10px");
        feedLayout.setWidth("100%");
        int imagesPerRow = 2;

        for (int i = 0; i < feedImageUrls.size(); i += imagesPerRow) {
            HorizontalLayout rowLayout = new HorizontalLayout();
            rowLayout.setWidth("100%");
            rowLayout.setSpacing(true);

            for (int j = i; j < Math.min(i + imagesPerRow, feedImageUrls.size()); j++) {
                Image feedImage = new Image(feedImageUrls.get(j), "Feed Image");
                feedImage.getStyle().set("width", "80px");
                feedImage.getStyle().set("height", "80px");
                rowLayout.add(feedImage);
            }

            feedLayout.add(rowLayout);
        }

        // Add components to the profile layout
        profileLayout.add(dogImage, dogNameField, bioField, saveButton, followLayout, feedLayout);

        // Add margin at the top of the profile layout
        profileLayout.getStyle().set("margin-top", "20px");

        // Add the profile layout to the main div
        add(profileLayout);

        // Customize the main div
        getStyle().set("background-color", "#f7f7f7");
        getStyle().set("padding", "20px");
        getStyle().set("border-radius", "10px");
        setWidth("300px");
    }

    protected void enableEditing() {
        // Enable editing of fields and show the save button
        dogNameField.setReadOnly(false);
        bioField.setReadOnly(false);
        saveButton.setVisible(true);
    }

    protected void saveProfileChanges() {
        // Disable editing of fields and hide the save button
        dogNameField.setReadOnly(true);
        bioField.setReadOnly(true);
        saveButton.setVisible(false);

        // Update the UI with the new values (optional)
        Notification.show("Profile updated successfully!");
    }
}
