package com.example.application.views.UserProfile;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Profile")
@Route(value = "User-Profile -- External User", layout = MainLayout.class)
@AnonymousAllowed
public class UserProfileView extends Div {
    private Button btnMessage;
    private Button btnFollow;
    private Label txtProfile;
    private Label txtPets;
    private Label txtDogsName;
    private String txtUserDecription;
    private TextArea description;

    private Button back;
    VerticalLayout mainFrame = new VerticalLayout();
    HorizontalLayout topBar = new HorizontalLayout();
    HorizontalLayout middleBar = new HorizontalLayout();
    VerticalLayout profilePanel = new VerticalLayout();
    VerticalLayout bottom = new VerticalLayout();


    public UserProfileView(){
        mainFrame.setPadding(true);
        topBar.setPadding(true);
        middleBar.setPadding(true);

        back = new Button();
        btnMessage = new Button("Message");
        btnFollow = new Button("Follow");

        Image btnBackImg = new Image("images/images.png", "Back button");
        btnBackImg.setWidth("40px");

        txtProfile = new Label("Profile");
        txtPets = new Label("Pets");
        txtDogsName = new Label("One Eye'd Joe");

        Image profileImage = new Image("images/profile2.png", "Profile Picture");
        profileImage.setWidth("106px");
        profileImage.setHeight("102px");

        txtUserDecription = new String("Decription uao-ccjoiaosidddddddddddddddddddddddddd" + "\n" + "dddddddddddddddddddso k oddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddsj ojofoidj");

        description = new TextArea("Description");
        description.setValue("Decription ia , the girl who kisse dher brother. my name is luto and i killed a dog by accident not really");
        description.setReadOnly(true);


        //dog
        Image dogImg = new Image("images/dog.png", "dogImg");
        dogImg.setWidth("300px");

        //action events

        btnFollow.addClickListener(e -> {
            btnFollow.setText("Following");
        });

        dogImg.addClickListener(e -> {
            dogImg.setWidth("366px");
            dogImg.setHeight("254px");
        });

        back.addClickListener(e -> {
            Notification.show("on menu page");
            getUI().ifPresent(ui ->  ui.navigate("about"));
        });

        btnMessage.addClickListener(e -> {
            Notification.show("on menu page");
            getUI().ifPresent(ui ->  ui.navigate("login"));

        });


        //style++++++++++++++++++++++++++++++++++++++++++++++++++++

        Style prof = profileImage.getStyle();
        prof.set("margin-left","auto");
        prof.set("margin-right", "auto");

        Style dog = dogImg.getStyle();
        dog.set("margin-left","auto");
        dog.set("margin-right", "auto");
        dog.set("border-radius", "7px");


        middleBar.setPadding(true);
        middleBar.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        //adding+++++++++++++++++++++++++++++++
        Style bgbutton = back.getStyle();
        back.setSizeUndefined();
        bgbutton.set("background-image", "url('images/images.png')");
        bgbutton.set("background-repeat", "no-repeat");
        bgbutton.set("background-size","50px 30px");
        bgbutton.set("padding","3px");
        bgbutton.set("width","51px");
        bgbutton.set("height","28px");
        back.addThemeVariants(ButtonVariant.LUMO_TERTIARY,
                ButtonVariant.LUMO_SUCCESS);


        topBar.add(back);
        this.add(topBar);

        profilePanel.add(txtProfile);
        profilePanel.add(profileImage);
        this.add(profilePanel);

        add(description);

        middleBar.add(btnFollow);
        middleBar.add(btnMessage);
        this.add(middleBar);

        bottom.add(txtPets);
        bottom.add(txtDogsName);
        bottom.add(dogImg);
        this.add(bottom);

        getStyles();

    }

    public void setData(){
        String descriptionValue = description.getValue();
        System.out.println(txtDogsName.toString());
        String DogName = txtDogsName.toString();

    }

    public void getStyles(){
        Style btnF = btnFollow.getStyle();
        btnF.set("margin-left","auto");
        btnF.set("border-radius", "7px");
        btnF.set("border-color","black" );
        btnF.set("background-color","white");
        btnF.set("color","#8F6666");
        btnF.set("padding", "10px 24px");
        btnF.set("border","3px solid black");
        btnF.set("width","125px");
        Style btnM = btnMessage.getStyle();
        btnM.set("margin-right", "auto");
        btnM.set("border-radius", "7px");
        btnM.set("border-color","black" );
        btnM.set("background-color","#8F6666");
        btnM.set("color","white");
        btnM.set("width","125px");





        mainFrame.setWidth("750px");

        Style profile = txtProfile.getStyle();
        profile.set("position", "relative");
        profile.set("left", 625+"px");
        profile.set("color", "black");
        profile.set("font-family", "Inter");
        profile.set("font-size", "22px");
        profile.set("font-weight", "bold");
        profile.set("font-style", "normal");
        profile.set("line-height", "normal");
        profile.set("width", "300px");

        Style descrip = description.getStyle();
        descrip.set("position","relative");
        descrip.set("left",435+"px");
        descrip.set("width","500px");

        Style txtDog = txtPets.getStyle();
        txtDog.set("position", "relative");
        txtDog.set("left", 400+"px");
        txtDog.set("color", "black");
        txtDog.set("font-family", "Inter");
        txtDog.set("font-size", "20px");
        txtDog.set("font-weight", "bold");
        txtDog.set("font-style", "normal");
        txtDog.set("line-height", "normal");
        txtDog.set("width", "300px");

        Style txtdogName = txtDogsName.getStyle();
        txtdogName.set("position", "relative");
        txtdogName.set("left", 590+"px");
        txtdogName.set("color", "black");
        txtdogName.set("font-family", "Inter");
        txtdogName.set("font-size", "20px");
        txtdogName.set("font-weight", "bold");
        txtdogName.set("font-style", "normal");
        txtdogName.set("line-height", "normal");
        txtdogName.set("width", "300px");
    }
}
