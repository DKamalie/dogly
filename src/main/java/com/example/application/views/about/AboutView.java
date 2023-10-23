package com.example.application.views.about;

import com.example.application.views.MainLayout;
import com.example.application.views.landing.LandingView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
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
public class AboutView extends VerticalLayout{

    private Html heading;
    private Html firstText;
    private Html secondText;
    private Html thirdText;
    private Image dogPic;
    private Button backButton;

    public AboutView(){

        backButton = new Button("Back");

        heading = new Html("<div><b>About Dogly</b><br></div>");

        firstText = new Html("<div>Welcome to our dog pairing web application! We are excited to provide a platform that helps dog owners find compatible playmates for their furry friends, as well as connect with other dog owners in their community.<br></div>");

        secondText = new Html("<div>The dog pairing web application is designed to help pet owners find compatible playmates for their pets. The platform simplifies the process of finding pets with similar temperaments and energy levels by allowing users to create pet profiles with information about their age, breed, size, and temperament. The application also provides information about dog-friendly parks and events in the user's area, as well as a feature for rating and reviewing pet-related businesses.<br></div>");

        thirdText = new Html("<div>We hope that you have an excellent time using our application. Thank you for believing in us.</div>");

        dogPic = new Image("images/dogAbout.png", "");
        dogPic.setWidth("400px");
        dogPic.setHeight("200px");

        backButton.addClickListener(e -> {
            getUI().ifPresent(ui -> ui.navigate(LandingView.class));
        });

        Style picStyle = dogPic.getStyle();
        picStyle.set("border-radius", "1%");

        Style headingStyle = heading.getStyle();
        headingStyle.set("font-family", "Arial");
        headingStyle.set("font-size", "20px");


        Style firstTextStyle = firstText.getStyle();
        firstTextStyle.set("font-family", "Arial");
        firstTextStyle.set("font-size", "15px");

        Style secondTextStyle = secondText.getStyle();
        secondTextStyle.set("font-family", "Arial");
        secondTextStyle.set("font-size", "15px");

        Style thirdTextStyle = firstText.getStyle();
        thirdTextStyle.set("font-family", "Arial");
        thirdTextStyle.set("font-size", "15px");

        Style buttonStyle = backButton.getStyle();
        buttonStyle.set("color", "white");
        buttonStyle.set("background-color", "#8F6666");
        buttonStyle.set("font-family", "Arial");
        buttonStyle.set("font-size", "16px");
        buttonStyle.set("font-weight", "bold");
        buttonStyle.set("border-radius", "17px");
        buttonStyle.set("box-shadow", "0 5px 4px rgba(0, 0, 0, 0.2)");

        setMargin(true);

        add(backButton, heading);
        add(firstText);
        add(secondText);
        add(thirdText);
        add(dogPic);



    }



}
