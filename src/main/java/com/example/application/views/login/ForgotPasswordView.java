

package com.example.application.views.login;

import com.example.application.dao.RegisterDAO;
import com.example.application.domain.ForgotPassword;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.auth.AnonymousAllowed;

/*
ForgotPasswordView.java
Author: Tamryn Lisa Lewin (219211981)
Date: 18 May 2023
 */

@PageTitle("Forgot password")
@Route(value = "forgotPassword", layout = MainLayout.class)
@RouteAlias(value = "forgotPassword", layout = MainLayout.class)
@AnonymousAllowed

public class ForgotPasswordView extends VerticalLayout {

    private Html forgot;
    private String email;
    private EmailField eFEmail;
    private Button btnSubmitEmail;
    private Text tRemember;
    private RouterLink loginLink, resetPasswordLink;
    private HorizontalLayout hlLogin;

    public ForgotPasswordView() {

        forgot = new Html("<div> No worries. Enter the email address you used when registering and we’ll re-direct you to create a new password.<br></div>");

        eFEmail = new EmailField("Email");
        eFEmail.setPlaceholder("Enter your email address");

        btnSubmitEmail = new Button("Submit");

        tRemember = new Text("Just remembered?");

        loginLink = new RouterLink("Login", LoginView.class);
        resetPasswordLink = new RouterLink("RestPassword", ResetPasswordView.class);

        hlLogin = new HorizontalLayout();
        hlLogin.add(tRemember, loginLink);

        btnSubmitEmail.addClickListener(buttonClickEvent -> {
            email = eFEmail.getValue();

            ForgotPassword forgotPassword = ForgotPassword.create(email);

            RegisterDAO dao = new RegisterDAO();
            boolean validateEmail = dao.validateEmail(email);

            if (forgotPassword.getEmail().isEmpty()) {
                Notification.show("Please enter your email address");
            } else {
                if (validateEmail) {
                    getUI().ifPresent(ui -> ui.navigate(ResetPasswordView.class));
                    VaadinSession.getCurrent().setAttribute("resetPasswordEmail", email);
                } else {
                    Notification.show("Please enter a valid email");
                }
            }
        });

        Style tFEmailStyle = eFEmail.getStyle();
        tFEmailStyle.set("font-family", "Arial");
        tFEmailStyle.set("font-size", "15px");
        tFEmailStyle.set("width", "300px");

        Style buttonStyle = btnSubmitEmail.getStyle();
        buttonStyle.set("color", "white");
        buttonStyle.set("background-color", "#8f6666");
        buttonStyle.set("font-family", "Arial");
        buttonStyle.set("font-size", "16px");
        buttonStyle.set("font-weight", "bold");
        buttonStyle.set("width", "300px");
        buttonStyle.set("border-radius", "17px");
        buttonStyle.set("box-shadow", "0 5px 4px rgba(0, 0, 0, 0.2)");

        Style links = hlLogin.getStyle();
        links.set("font-family", "Arial");
        links.set("font-size", "16px");
        links.set("font-weight", "bold");

        setMargin(true);

        add(forgot);
        add(eFEmail);
        add(btnSubmitEmail);
        add(hlLogin);
    }

}
