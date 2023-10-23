package com.example.application.views.UserProfile;

import com.example.application.dao.UserProfileDAO;
import com.example.application.domain.UserProfile;
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

import java.sql.Blob;

@PageTitle("User Profile")
@Route(value = "User-Profile -- Internal User", layout = MainLayout.class)
@AnonymousAllowed
public class InternalUserProfileView extends Div {
    private Button btnFollow;
    private Label txtProfile;
    private Label txtPets;
    private Label txtDogsName;
    private String txtUserDecription;
    private TextArea description;
    private TextArea dogNAME;
    private Button btnEdit;
    private Button btnEdit2;
    private Button btnEdit3;
    private Button back;
    private Button btnSave;
    private Button btnSave2;

    VerticalLayout mainFrame = new VerticalLayout();
    HorizontalLayout topBar = new HorizontalLayout();
    HorizontalLayout middleBar = new HorizontalLayout();
    VerticalLayout profilePanel = new VerticalLayout();
    VerticalLayout bottom = new VerticalLayout();
    HorizontalLayout decripPanel = new HorizontalLayout();
    UserProfile user = new UserProfile();

    public InternalUserProfileView(){
        mainFrame.setPadding(true);
        topBar.setPadding(true);
        middleBar.setPadding(true);

        back = new Button();
        btnFollow = new Button("Followers: 286 891");
        btnEdit = new Button();
        btnEdit2 = new Button();
        btnEdit3 = new Button();
        btnSave = new Button();
        btnSave2 = new Button();

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

        dogNAME  = new TextArea("Dogs Name:");
        dogNAME.setValue("Type your new dog name here");
        //dogNAME.setVisible(false);


        //dog
        Image dogImg = new Image("images/dog.png", "dogImg");
        dogImg.setWidth("300px");

        //bg
        Image bg = new Image("images/bg.png", "");

        //action events

        back.addClickListener(e -> {
            Notification.show("on menu page");
            getUI().ifPresent(ui ->  ui.navigate("comment"));
        });

        btnSave2.addClickListener(e -> {
            String descriptionValue = description.getValue();
            btnSave2.setVisible(false);
            btnEdit2.setVisible(true);
            btnEdit3.setVisible(true);
            description.setReadOnly(true);
        });

        btnEdit2.addClickListener(e -> {
            description.setReadOnly(false);
            btnEdit.setVisible(false);
            btnEdit2.setVisible(false);
            btnEdit3.setVisible(false);
            btnSave2.setVisible(true);
        });

        btnEdit3.addClickListener(e -> {
            bottom.add(dogNAME);
            dogNAME.setVisible(true);

            btnEdit.setVisible(false);
            btnEdit2.setVisible(false);
            btnEdit3.setVisible(false);
            btnSave.setVisible(true);

        });


        dogImg.addClickListener(e -> {
            Style dogImges = dogImg.getStyle();
            dogImg.setWidth("366px");
            dogImg.setHeight("254px");
            Style r = this.getStyle();
            r.set("background-image", "url('images/bg.png')");
            r.set("filter","blur(8px)");
            r.set("-webkit-filter", "blur(8px)");

//            dogImges.set("filter","blur(8px)");
//            dogImges.set("-webkit-filter", "blur(8px)");


        });

        btnSave.addClickListener(e -> {
            btnSave.setVisible(false);
            btnEdit2.setVisible(true);
            btnEdit3.setVisible(true);

            String temp = dogNAME.getValue();
            txtDogsName.setText(temp);
            dogNAME.setVisible(false);
        });

        //style++++++++++++++++++++++++++++++++++++++++++++++++++++

        Style prof = profileImage.getStyle();
        prof.set("margin-left","auto");
        prof.set("margin-right", "auto");

        Style dog = dogImg.getStyle();
        dog.set("margin-left","auto");
        dog.set("margin-right", "auto");
        dog.set("border-radius", "7px");

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

        Style edit = btnEdit.getStyle();
        btnEdit.setSizeUndefined();
        edit.set("background-image", "url('images/edit.png')");
        edit.set("background-repeat", "no-repeat");
        edit.set("background-size","40px 25px");
        edit.set("padding","3px");
        edit.set("width","43px");
        edit.set("height","25px");
        edit.set("margin-left","auto");
        btnEdit.addThemeVariants(ButtonVariant.LUMO_TERTIARY,
                ButtonVariant.LUMO_SUCCESS);



        Style edit2 = btnEdit2.getStyle();
        btnEdit2.setSizeUndefined();
        edit2.set("background-image", "url('images/edit.png')");
        edit2.set("background-repeat", "no-repeat");
        edit2.set("background-size","40px 25px");
        edit2.set("padding","3px");
        edit2.set("width","43px");
        edit2.set("height","25px");
        edit2.set("margin-left","auto");
        edit2.set("left", 0+"px");
        btnEdit2.addThemeVariants(ButtonVariant.LUMO_TERTIARY,
                ButtonVariant.LUMO_SUCCESS);


        Style edit3 = btnEdit3.getStyle();
        btnEdit3.setSizeUndefined();
        edit3.set("background-image", "url('images/edit.png')");
        edit3.set("background-repeat", "no-repeat");
        edit3.set("background-size","40px 25px");
        edit3.set("padding","3px");
        edit3.set("width","43px");
        edit3.set("height","25px");
        edit3.set("margin-left","auto");
        btnEdit3.addThemeVariants(ButtonVariant.LUMO_TERTIARY,
                ButtonVariant.LUMO_SUCCESS);

        Style saveButton = btnSave.getStyle();
        btnSave.setSizeUndefined();
        saveButton.set("background-image", "url('images/save.png')");
        saveButton.set("background-repeat", "no-repeat");
        saveButton.set("background-size","40px 25px");
        saveButton.set("padding","3px");
        saveButton.set("width","43px");
        saveButton.set("height","25px");
        saveButton.set("margin-left","auto");
        btnSave.setVisible(false);
        btnSave.addThemeVariants(ButtonVariant.LUMO_TERTIARY,
                ButtonVariant.LUMO_SUCCESS);

        Style saveButton2 = btnSave2.getStyle();
        btnSave2.setSizeUndefined();
        saveButton2.set("background-image", "url('images/save.png')");
        saveButton2.set("background-repeat", "no-repeat");
        saveButton2.set("background-size","40px 25px");
        saveButton2.set("padding","3px");
        saveButton2.set("width","43px");
        saveButton2.set("height","25px");
        saveButton2.set("margin-left","auto");
        btnSave2.setVisible(false);
        btnSave2.addThemeVariants(ButtonVariant.LUMO_TERTIARY,
                ButtonVariant.LUMO_SUCCESS);

        middleBar.setPadding(true);
        middleBar.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        //adding+++++++++++++++++++++++++++++++

        topBar.add(back);
        topBar.add(btnSave2);
        this.add(topBar);

        profilePanel.add(txtProfile);
        profilePanel.add(profileImage);
        this.add(profilePanel);


        decripPanel.add(description);
        decripPanel.add(btnSave);
        decripPanel.add(btnEdit2);
        this.add(decripPanel);

        middleBar.add(btnFollow);
        this.add(middleBar);

        bottom.add(txtPets);
        bottom.add(btnEdit3);
        bottom.add(txtDogsName);
        bottom.add(dogImg);
        this.add(bottom);

        getStyles();

    }
    public void setData(){
        String descriptionValue = description.getValue();
        //String DogName = txtDogsName.getText();
        UserProfileDAO u = new UserProfileDAO();

//              user.setUserprofileID(),
//                user.setUserID(),
//                user.setLocationID(),
//                user.setName(),
//                user.setAge(),
//                user.setDescription(descriptionValue),
//                user.setProfilePhoto()
//
//        u.saveUserProfile();
    }

    public void getStyles(){
        Style btnF = btnFollow.getStyle();
        btnF.set("margin-left","auto");
        btnF.set("margin-right","auto");
        btnF.set("border-radius", "7px");
        btnF.set("border-color","black" );
        btnF.set("background-color","white");
        btnF.set("color","#8F6666");
        btnF.set("padding", "10px 24px");
        btnF.set("border","3px solid black");
        btnF.set("width","325px");

        mainFrame.setWidth("750px");

        Style profile = txtProfile.getStyle();
        profile.set("position", "relative");
        profile.set("right", -790+"px");
        profile.set("color", "black");
        profile.set("font-family", "Inter");
        profile.set("font-size", "22px");
        profile.set("font-weight", "bold");
        profile.set("font-style", "normal");
        profile.set("line-height", "normal");
        profile.set("width", "300px");

        Style descrip = description.getStyle();
        descrip.set("position","relative");
        descrip.set("left",705+"px");
        descrip.set("width","500px");

        Style del = dogNAME.getStyle();
        del.set("position","relative");
        del.set("left",700+"px");
        del.set("width","300px");

        Style txtDog = txtPets.getStyle();
        txtDog.set("position", "relative");
        txtDog.set("left", 500+"px");
        txtDog.set("color", "black");
        txtDog.set("font-family", "Inter");
        txtDog.set("font-size", "20px");
        txtDog.set("font-weight", "bold");
        txtDog.set("font-style", "normal");
        txtDog.set("line-height", "normal");
        txtDog.set("width", "300px");

        Style txtdogName = txtDogsName.getStyle();
        txtdogName.set("position", "relative");
        txtdogName.set("left", 690+"px");
        txtdogName.set("color", "black");
        txtdogName.set("font-family", "Inter");
        txtdogName.set("font-size", "20px");
        txtdogName.set("font-weight", "bold");
        txtdogName.set("font-style", "normal");
        txtdogName.set("line-height", "normal");
        txtdogName.set("width", "300px");
    }
}
