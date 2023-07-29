

package com.example.application.views.login;

import com.example.application.dao.RegisterDAO;
import com.example.application.domain.Login;
import com.example.application.views.MainLayout;
import com.example.application.views.registration.RegistrationView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;

/*
LoginView.java
Author: Tamryn Lisa Lewin (219211981)
Date: 18 May 2023
 */

@PageTitle("Login")
@Route(value = "login", layout = MainLayout.class)
@RouteAlias(value = "login", layout = MainLayout.class)
@AnonymousAllowed

public class LoginView extends VerticalLayout {

    private TextField tFUsernameOrEmail;
    private PasswordField pFPassword;
    private Button btnLogin;
    private RouterLink forgotLink, createLink;
    private HorizontalLayout hlForgotCreate;

    public LoginView() {

        tFUsernameOrEmail = new TextField("Username or email address");
        tFUsernameOrEmail.setPlaceholder("Enter your username or email address");

        pFPassword = new PasswordField("Password");
        pFPassword.setPlaceholder("Enter your password");

        btnLogin = new Button("Login");

        forgotLink = new RouterLink("Forgot password?", ForgotPasswordView.class);
        createLink = new RouterLink("Create account", ResetPasswordView.class);

        hlForgotCreate = new HorizontalLayout();
        hlForgotCreate.add(forgotLink, createLink);


        btnLogin.addClickListener(buttonClickEvent -> {
            String usernameOrEmail = tFUsernameOrEmail.getValue();
            String password = pFPassword.getValue();

            Login login = Login.create(usernameOrEmail, password);

            RegisterDAO registerDAO = new RegisterDAO();
            boolean loginValid = registerDAO.validateLogin(usernameOrEmail, password);
            RegistrationView rv = new RegistrationView();
            boolean isEmail = rv.isValidEmail(usernameOrEmail);
            boolean isUsername = !isEmail;

            if (login.getUsernameOrEmail().isEmpty() || login.getPassword().isEmpty()) {
                Notification.show("Please fill in all fields");
            }

            else if (!loginValid) {
                if (isEmail) {
                    boolean invalidEmail = !registerDAO.checkEmailExists(usernameOrEmail);
                    if (invalidEmail) {
                        Notification.show("Invalid email, please try again");
                    } else {
                        Notification.show("Invalid password, please try again or the email and password doesn't match");
                    }
                } else if (isUsername) {
                    boolean invalidUsername = !registerDAO.checkUsernameExists(usernameOrEmail);
                    if (invalidUsername) {
                        Notification.show("Invalid username, please try again");
                    } else {
                        Notification.show("Invalid password, please try again or the username and password doesn't match");
                    }
                }
            }
            else {
                Notification.show("Login successful!");

                getUI().ifPresent(ui -> ui.navigate("about"));
            }
        });

        Style tFUsernameOrEmailStyle = tFUsernameOrEmail.getStyle();
        tFUsernameOrEmailStyle.set("font-family", "Arial");
        tFUsernameOrEmailStyle.set("font-size", "15px");
        tFUsernameOrEmailStyle.set("width", "300px");

        Style tFPasswordStyle = pFPassword.getStyle();
        tFPasswordStyle.set("font-family", "Arial");
        tFPasswordStyle.set("font-size", "15px");
        tFPasswordStyle.set("width", "300px");

        Style buttonStyle = btnLogin.getStyle();
        buttonStyle.set("color", "white");
        buttonStyle.set("background-color", "#8f6666");
        buttonStyle.set("font-family", "Arial");
        buttonStyle.set("font-size", "16px");
        buttonStyle.set("font-weight", "bold");
        buttonStyle.set("width", "300px");
        buttonStyle.set("border-radius", "17px");
        buttonStyle.set("box-shadow", "0 5px 4px rgba(0, 0, 0, 0.2)");

        Style links = hlForgotCreate.getStyle();
        links.set("font-family", "Arial");
        links.set("font-size", "16px");
        links.set("font-weight", "bold");

        setMargin(true);

        add(tFUsernameOrEmail);
        add(pFPassword);
        add(btnLogin);
        add(hlForgotCreate);
    }

}