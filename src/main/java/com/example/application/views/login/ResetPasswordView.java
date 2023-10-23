

package com.example.application.views.login;

import com.example.application.dao.RegisterDAO;
import com.example.application.domain.ResetPassword;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;


/*
ResetPasswordView.java
Author: Tamryn Lisa Lewin (219211981)
Date: 18 May 2023
 */

@PageTitle("Reset password")
@Route(value = "resetPassword", layout = MainLayout.class)
@RouteAlias(value = "resetPassword", layout = MainLayout.class)
@AnonymousAllowed

public class ResetPasswordView extends VerticalLayout {

    private Html reset;
    private PasswordField pFNewPassword, pFConfirmNewPassword;
    private Button btnResetPassword;

    public ResetPasswordView() {

        reset = new Html("<div> Enter and confirm your new password.<br></div>");

        pFNewPassword = new PasswordField("Password");
        pFNewPassword.setPlaceholder("Enter your new password");

        pFConfirmNewPassword = new PasswordField("Confirm password");
        pFConfirmNewPassword.setPlaceholder("Confirm your new password");

        btnResetPassword = new Button("Reset password");

        btnResetPassword.addClickListener(buttonClickEvent -> {
            String newPassword = pFNewPassword.getValue();
            String confirmNewPassword = pFConfirmNewPassword.getValue();


            ResetPassword resetPassword = ResetPassword.create(newPassword, confirmNewPassword);

            RegisterDAO registerDAO = new RegisterDAO();
            ForgotPasswordView forgotPassword = new ForgotPasswordView();


            if (newPassword.isEmpty()) {
                Notification.show("Please enter your new password");
            } else if (confirmNewPassword.isEmpty()) {
                Notification.show("Please re-enter your new password to confirm it");
            } else if (!confirmNewPassword.equals(newPassword)) {
                Notification.show("Please ensure you are entering the exact new password");
            } else if (newPassword.length() < 8) {
                Notification.show("The password can't be shorter than 8 characters");
            } else {

                VaadinSession session = VaadinSession.getCurrent();
                String email = (String) session.getAttribute("resetPasswordEmail");

                if (email != null) {

                    boolean passwordUpdated = registerDAO.updatePassword(email, newPassword);

                    if (passwordUpdated) {
                        Notification.show("Your password has been updated!");

                        getUI().ifPresent(ui -> ui.navigate("login"));
                    } else {
                        Notification.show("Failed to update the password");
                    }
                } else {
                    Notification.show("Email not found in the session");
                }
            }
        });

        Style pFPasswordStyle = pFNewPassword.getStyle();
        pFPasswordStyle.set("font-family", "Arial");
        pFPasswordStyle.set("font-size", "15px");
        pFPasswordStyle.set("width", "300px");

        Style pFConfirmStyle = pFConfirmNewPassword.getStyle();
        pFConfirmStyle.set("font-family", "Arial");
        pFConfirmStyle.set("font-size", "15px");
        pFConfirmStyle.set("width", "300px");

        Style buttonStyle = btnResetPassword.getStyle();
        buttonStyle.set("color", "white");
        buttonStyle.set("background-color", "#8f6666");
        buttonStyle.set("font-family", "Arial");
        buttonStyle.set("font-size", "16px");
        buttonStyle.set("font-weight", "bold");
        buttonStyle.set("width", "300px");
        buttonStyle.set("border-radius", "17px");
        buttonStyle.set("box-shadow", "0 5px 4px rgba(0, 0, 0, 0.2)");

        setMargin(true);

        add(reset);
        add(pFNewPassword);
        add(pFConfirmNewPassword);
        add(btnResetPassword);
    }


}