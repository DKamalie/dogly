package com.example.application.views.about;

import com.example.application.views.MainLayout;
import com.example.application.views.landing.LandingView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
@RouteAlias(value = "about", layout = MainLayout.class)
@AnonymousAllowed
public class AboutView extends VerticalLayout {

    private Html heading;
    private Html firstText;
    private Html secondText;
    private Html thirdText;
    private Image plant1, plant2, plant3, plant4, plant5, plant6;
    private Image plant7, plant8, plant9, plant10, plant11, plant12;
    private Button backButton = new Button("Back");
    Div mainGrid = new Div();
    Div text = new Div();
    Div imageContainer = new Div();
    H1 h1 = new H1("About Dogly");
    Paragraph p1 = new Paragraph("The dog pairing web application is designed to help pet owners find compatible playmates for their pets. The platform simplifies the process of finding pets with similar temperaments and energy levels by allowing users to create pet profiles with information about their age, breed, size, and temperament. The application also provides information about dog-friendly parks and events in the user's area, as well as a feature for rating and reviewing pet-related businesses.");
    Paragraph p2 = new Paragraph("We hope that you have an excellent time using our application. Thank you for believing in us.");

    public AboutView() {
        // Set back button
        backButton.addClickListener(e -> { getUI().ifPresent(ui -> ui.navigate(LandingView.class)); });
        // Set class names
        mainGrid.addClassName("mainGrid");
        imageContainer.addClassName("imageContainer");
        imageContainer.addClassNames();
        text.addClassName("textDiv");
        h1.addClassName("heading1");
        p1.addClassName("p1");
        p2.addClassName("p2");
        backButton.addClassName("back");
        text.add(backButton, h1, p1, p2);

        // Dog containers
        plant1 = new Image("images/yellow.png", "");
        plant2 = new Image("images/blue.png", "");
        plant3 = new Image("images/pink.png", "");
        plant4 = new Image("images/lightpink.png", "");
        plant5 = new Image("images/darkpink.png", "");
        plant6 = new Image("images/glasses.png", "");
        plant7 = new Image("images/laying.png", "");
        plant8 = new Image("images/labrador.png", "");
        plant9 = new Image("images/lookingup.png", "");
        plant10 = new Image("images/tired.png", "");
        plant11 = new Image("images/twodogs.png", "");
        plant12 = new Image("images/orange.png", "");

//        plant1.setWidth("100%");plant1.setHeight("100%");
//        plant2.setWidth("100%");plant2.setHeight("100%");
//        plant3.setWidth("100%");plant3.setHeight("100%");
//        plant4.setWidth("100%");plant4.setHeight("100%");
//        plant5.setWidth("100%");plant5.setHeight("100%");
//        plant6.setWidth("100%");plant6.setHeight("100%");
//        plant7.setWidth("100%");plant7.setHeight("100%");
//        plant8.setWidth("100%");plant8.setHeight("100%");
//        plant9.setWidth("100%");plant9.setHeight("100%");
//        plant10.setWidth("100%");plant10.setHeight("100%");
//        plant11.setWidth("100%");plant11.setHeight("100%");
//        plant12.setWidth("100%");plant12.setHeight("100%");

        plant1.addClassNames("plant1", "plant");
        plant2.addClassNames("plant2", "plant");
        plant3.addClassNames("plant3", "plant");
        plant4.addClassNames("plant4", "plant");
        plant5.addClassNames("plant5", "plant");
        plant6.addClassNames("plant6", "plant");
        plant7.addClassNames("plant7", "plant");
        plant8.addClassNames("plant8", "plant");
        plant9.addClassNames("plant9", "plant");
        plant10.addClassNames("plant10", "plant");
        plant11.addClassNames("plant11", "plant");
        plant12.addClassNames("plant12", "plant");

        imageContainer.add(plant1, plant2, plant3, plant4, plant5, plant6, plant7, plant8, plant9, plant10, plant11, plant12);


        mainGrid.add(text, imageContainer);
        add(mainGrid);





//        Style picStyle = dogPic.getStyle();
//        picStyle.set("border-radius", "1%");
//
//        Style headingStyle = heading.getStyle();
//        headingStyle.set("font-family", "Arial");
//        headingStyle.set("font-size", "20px");
//
//
//        Style firstTextStyle = firstText.getStyle();
//        firstTextStyle.set("font-family", "Arial");
//        firstTextStyle.set("font-size", "15px");
//
//        Style secondTextStyle = secondText.getStyle();
//        secondTextStyle.set("font-family", "Arial");
//        secondTextStyle.set("font-size", "15px");
//
//        Style thirdTextStyle = firstText.getStyle();
//        thirdTextStyle.set("font-family", "Arial");
//        thirdTextStyle.set("font-size", "15px");
//
//        Style buttonStyle = backButton.getStyle();
//        buttonStyle.set("color", "white");
//        buttonStyle.set("background-color", "#8F6666");
//        buttonStyle.set("font-family", "Arial");
//        buttonStyle.set("font-size", "16px");
//        buttonStyle.set("font-weight", "bold");
//        buttonStyle.set("border-radius", "17px");
//        buttonStyle.set("box-shadow", "0 5px 4px rgba(0, 0, 0, 0.2)");
//
//        setMargin(true);
//
//        add(backButton, heading);
//        add(firstText);
//        add(secondText);
//        add(thirdText);
//        add(dogPic);
//


    }



}