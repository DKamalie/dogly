package com.example.application.views.registration;

import com.example.application.dao.RegisterDAO;
import com.example.application.domain.Registration;
import com.example.application.views.MainLayout;
import com.example.application.views.login.LoginView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.dom.Style;
import java.util.InputMismatchException;

@PageTitle("Registration")
@Route(value = "registration", layout = MainLayout.class)
@RouteAlias(value = "registration", layout = MainLayout.class)
@AnonymousAllowed
public class RegistrationView extends VerticalLayout {

    private Text alreadyWithUs;
    private RouterLink loginLink;
    private TextField firstName;
    private TextField lastName;
    private EmailField email;
    private TextField username;
    private PasswordField password;
    private Button btnSubmit;
    private HorizontalLayout hL;


    public RegistrationView() {

        alreadyWithUs = new Text("Already with us?");
        loginLink = new RouterLink("Login", LoginView.class);
        hL = new HorizontalLayout();
        hL.add(alreadyWithUs, loginLink);
        firstName = new TextField("First name:");
        firstName.setWidth("300px");
        firstName.setPlaceholder("Enter your first name");
        lastName = new TextField("Last name:");
        lastName.setWidth("300px");
        lastName.setPlaceholder("Enter your last name");
        email = new EmailField("Email address:");
        email.setWidth("300px");
        email.setPlaceholder("Enter your email");
        username = new TextField("Username:");
        username.setWidth("300px");
        username.setPlaceholder("Enter your username");
        password = new PasswordField("Password:");
        password.setWidth("300px");
        password.setPlaceholder("Enter your password");
        btnSubmit = new Button("Submit");
        btnSubmit.setWidth("300px");


        btnSubmit.addClickListener(e -> {
            try {
                boolean hasErrors = Errors();

                if (!hasErrors) {
                    dao.saveRegistration(reg);
                }
            } catch (Exception exception) {
                Notification.show(exception.getMessage());
            }
        });

        Style buttonStyle = btnSubmit.getStyle();
        buttonStyle.set("color", "white");
        buttonStyle.set("background-color", "#8F6666");
        buttonStyle.set("font-family", "Arial");
        buttonStyle.set("font-size", "16px");
        buttonStyle.set("font-weight", "bold");
        buttonStyle.set("border-radius", "17px");
        buttonStyle.set("box-shadow", "0 5px 4px rgba(0, 0, 0, 0.2)");
        buttonStyle.set("margin-right", "auto");
        buttonStyle.set("margin-left", "auto");

        Style alreadyStyle = hL.getStyle();
        alreadyStyle.set("font-family", "Arial");
        alreadyStyle.set("font-size", "16px");
        alreadyStyle.set("font-weight", "bold");
        alreadyStyle.set("margin-right", "auto");
        alreadyStyle.set("margin-left", "auto");

        Style firstNameTextField = firstName.getStyle();
        firstNameTextField.set("font-family", "Arial");
        firstNameTextField.set("font-size", "15px");
        firstNameTextField.set("margin-right", "auto");
        firstNameTextField.set("margin-left", "auto");

        Style lastNameTextField = lastName.getStyle();
        lastNameTextField.set("font-family", "Arial");
        lastNameTextField.set("font-size", "15px");
        lastNameTextField.set("margin-right", "auto");
        lastNameTextField.set("margin-left", "auto");

        Style emailTextField = email.getStyle();
        emailTextField.set("font-family", "Arial");
        emailTextField.set("font-size", "15px");
        emailTextField.set("margin-right", "auto");
        emailTextField.set("margin-left", "auto");

        Style usernameTextField = username.getStyle();
        usernameTextField.set("font-family", "Arial");
        usernameTextField.set("font-size", "15px");
        usernameTextField.set("margin-right", "auto");
        usernameTextField.set("margin-left", "auto");

        Style passwordTextField = password.getStyle();
        passwordTextField.set("font-family", "Arial");
        passwordTextField.set("font-size", "15px");
        passwordTextField.set("margin-right", "auto");
        passwordTextField.set("margin-left", "auto");

        setMargin(true);

        add(hL);
        add(firstName);
        add(lastName);
        add(email);
        add(username);
        add(password);
        add(btnSubmit);

    }
    RegisterDAO dao = new RegisterDAO();
    Registration reg = new Registration();

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        return email.matches(emailRegex);
    }

    public Boolean Errors() {

        String firstNameValue = firstName.getValue();
        String lastNameValue = lastName.getValue();
        String emailValue = email.getValue();
        String usernameValue = username.getValue();
        String passwordValue = password.getValue();

        if (firstNameValue.isEmpty() || lastNameValue.isEmpty() || emailValue.isEmpty() || usernameValue.isEmpty() || passwordValue.isEmpty()) {
            Notification.show("Please enter in all the required fields");
            return true;
        }

            if(!firstNameValue.matches("[a-zA-Z]+") || !lastNameValue.matches("[a-zA-Z]+") ){
                throw new InputMismatchException(("Invalid input, please only enter in letters for your first name or last name"));
            }

        if (!isValidEmail(emailValue)){
            Notification.show("Invalid email, please try again");
            return true;
        }
            if(passwordValue.length() < 8){
                Notification.show("The password length is below 8");
                return true;
            }

            if(dao.checkEmailExists(emailValue)){
                Notification.show("Email taken");
                return true;
            }

            if(dao.checkUsernameExists(usernameValue)){
                Notification.show("Username taken");
                return true;
            }

            if(dao.checkPasswordExists(passwordValue)){
                Notification.show("Password taken");
                return true;
            }
        else {
            reg.setFirstName(firstNameValue);
            reg.setLastName(lastNameValue);
            reg.setEmail(emailValue);
            reg.setUsername(usernameValue);
            reg.setPassword(passwordValue);
            Notification.show("Registration successful");
             getUI().ifPresent(ui -> ui.navigate(LoginView.class));
            return false;
        }
    }
}

