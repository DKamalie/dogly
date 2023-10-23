package com.example.application.views.dogprofile;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@PageTitle("DogProfile")
@Route(value = "userdog", layout = MainLayout.class)
@RouteAlias(value = "userdog", layout = MainLayout.class)
@AnonymousAllowed
public class UserDogProfileView extends Div {

    private int numberOfFollowers = new Random().nextInt(10000); // Initialize followers count randomly
    private Div followersDiv = new Div();

    public UserDogProfileView() {
        // Create a vertical layout to hold the profile information
        VerticalLayout profileLayout = new VerticalLayout();
        profileLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        // User's image (you can set the image URL accordingly)
        Image userImage = new Image("/images/doggo.jpg", "User Image");
        userImage.getStyle().set("width", "120px");
        userImage.getStyle().set("height", "120px");
        userImage.getStyle().set("border-radius", "50%");

        // Non-editable fields
        Div userNameField = new Div();
        userNameField.setText("John Doe");
        Div bioField = new Div();
        bioField.setText("I'm a user of this application. Nice to meet you!");

        // Follow button and number of followers
        Button followButton = new Button("Follow");
        followButton.getStyle().set("background-color", "brown");
        followButton.getStyle().set("color", "white");
        followButton.getStyle().set("width", "80px");
        followButton.addClickListener(event -> {
            if ("Follow".equals(followButton.getText())) {
                followButton.setText("Following");
                numberOfFollowers++;
            } else {
                followButton.setText("Follow");
                numberOfFollowers--;
            }
            followersDiv.setText(numberOfFollowers + " Followers");
        });

        followersDiv.setText(numberOfFollowers + " Followers");
        followersDiv.getStyle().set("font-weight", "bold");

        // Feed images (different images in the feed)
        VerticalLayout feedLayout = new VerticalLayout();
        feedLayout.getStyle().set("margin-top", "10px");
        feedLayout.setWidth("100%");
        int imagesPerRow = 2;

        List<String> feedImageUrls = Arrays.asList(
                "/images/doggo.jpg",
                "/images/doggo.jpg",
                "/images/doggo.jpg",
                "/images/doggo.jpg"
        );

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

        profileLayout.add(userImage, userNameField, bioField, followButton, followersDiv, feedLayout);

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
}
