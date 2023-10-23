package com.example.application.views.landing;

import com.example.application.views.MainLayout;
import com.example.application.views.about.AboutView;
import com.example.application.views.login.LoginView;
import com.example.application.views.registration.RegistrationView;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Landing")
@Route(value = "landing", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@AnonymousAllowed
public class LandingView extends VerticalLayout {

    private Image logo;
    private Image dog;
    private RouterLink aboutLink, loginLink, registerLink;
    private Html welcome;
    private Html slogan;
    private Html ad;
    private Button btnLogin, btnRegister;

    private HorizontalLayout hL, hLB;


    public LandingView()  {

        logo = new Image("images/collection-dogs-different-breeds.png", "");
        logo.setWidth("75px");
        logo.setHeight("60px");
        aboutLink = new RouterLink("About", AboutView.class);
        loginLink = new RouterLink("Login", LoginView.class);
        registerLink = new RouterLink("Register", RegistrationView.class);
        hL = new HorizontalLayout();
        hL.add(logo, aboutLink, registerLink, loginLink);
        welcome = new Html("<div>Welcome to Dogly<br></div>");
        slogan = new Html("<div>Pawsitive connections, where dogs discover their ideal companions!<br></div>");
        dog = new Image("images/lab.png", "");
        dog.setWidth("400px");
        dog.setHeight("200px");
        ad = new Html("<div>Are you a dog lover looking for the pawfect companion for your dog?<br>" +
                "Look no further!<br>" +
                "Our innovative Dogly web app is here to make your search easier, more efficient and incredibly fulfilling</div>");
        btnLogin = new Button("or Login");
        btnRegister = new Button("Register");
        hLB = new HorizontalLayout();
        hLB.add(btnRegister, btnLogin);

        btnRegister.addClickListener(e -> {
            getUI().ifPresent(ui -> ui.navigate(RegistrationView.class));
        });

        btnLogin.addClickListener(e -> {
            getUI().ifPresent(ui -> ui.navigate(LoginView.class));
        });


        Style logo1 = logo.getStyle();
        logo1.set("border-radius", "20%");

        Style dog1 = dog.getStyle();
        dog1.set("border-radius", "1%");

        Style links = hL.getStyle();
        links.set("font-family", "Arial");
        links.set("font-size", "16px");
        links.set("font-weight", "bold");

        Style welcomeStyle = welcome.getStyle();
        welcomeStyle.set("font-family", "Arial");
        welcomeStyle.set("font-size", "20px");
        welcomeStyle.set("font-weight", "bold");

        Style sloganStyle = slogan.getStyle();
        sloganStyle.set("font-family", "Arial");
        sloganStyle.set("font-size", "15px");

        Style adStyle = ad.getStyle();
        adStyle.set("font-family", "Arial");
        adStyle.set("font-size", "15px");

        Style buttonStyle = btnLogin.getStyle();
        buttonStyle.set("color", "#8f6666");
        buttonStyle.set("background-color", "white");
        buttonStyle.set("font-family", "Arial");
        buttonStyle.set("font-size", "16px");
        buttonStyle.set("font-weight", "bold");
        buttonStyle.set("border-radius", "17px");
        buttonStyle.set("box-shadow", "0 5px 4px rgba(0, 0, 0, 0.2)");

        Style buttonRStyle = btnRegister.getStyle();
        buttonRStyle.set("color", "white");
        buttonRStyle.set("background-color", "#8f6666");
        buttonRStyle.set("font-family", "Arial");
        buttonRStyle.set("font-size", "16px");
        buttonRStyle.set("font-weight", "bold");
        buttonRStyle.set("border-radius", "17px");
        buttonRStyle.set("box-shadow", "0 5px 4px rgba(0, 0, 0, 0.2)");

        setMargin(true);

        add(hL);
        add(welcome);
        add(slogan);
        add(dog);
        add(ad);
        add(hLB);

    }
}


