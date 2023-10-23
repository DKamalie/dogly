package com.example.application.views.home;

import com.example.application.views.MainLayout;
import com.example.application.views.about.AboutView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Home")
@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "home", layout = MainLayout.class)
@AnonymousAllowed
public class HomeView extends VerticalLayout {

    public HomeView() {
        String[] postImageUrls = {
                "/images/dog1.png",
                "/images/dog2.png",
                "/images/dog3.png",
        };

        String[] postCaptions = {
                "My twinie brownies",
                "Princesses birthday, horray!!",
                "Chubby gooffies"
        };

        String[] userIcons = {
                "/images/icon11.png",
                "/images/icon22.png",
                "/images/icon33.png"
        };


        for (int i = 0; i < postImageUrls.length; i++) {
            Image postImage = new Image(postImageUrls[i], "Dogly Post Image");
            postImage.setWidth("400px");

            Image userIcon = new Image(userIcons[i], "User Icon");
            userIcon.setWidth("50px");
            userIcon.setHeight("50px");
            userIcon.getStyle().set("border-radius", "50%");


            Paragraph caption = new Paragraph(postCaptions[i]);
            caption.getStyle().set("color", "white");

            Button likeButton = new Button(VaadinIcon.HEART.create());
            likeButton.getStyle()
                    .set("color", "black")
                    .set("background-color", "transparent");

            boolean[] isLiked = {false};
            likeButton.addClickListener(event -> {
                if (!isLiked[0]) {
                    likeButton.setIcon(VaadinIcon.HEART.create());
                    likeButton.getStyle().set("color", "red");
                    isLiked[0] = true;
                } else {
                    likeButton.setIcon(VaadinIcon.HEART.create());
                    likeButton.getStyle().set("color", "white");
                    isLiked[0] = false;
                }
            });

            Button commentButton = new Button("Comment");

            likeButton.getStyle().set("background-color", "#9ACD32");
            likeButton.getStyle().set("color", "#ffffff");
            likeButton.getStyle().set("border", "none");
            likeButton.getStyle().set("border-radius", "5px");
            likeButton.getStyle().set("margin-right", "10px");

            commentButton.getStyle().set("background-color", "#9ACD32");
            commentButton.getStyle().set("color", "#ffffff");
            commentButton.getStyle().set("border", "none");
            commentButton.getStyle().set("border-radius", "5px");

            commentButton.addClickListener(event -> commentButton.getUI().ifPresent(ui -> ui.navigate("comment")));

            HorizontalLayout userInfoLayout = new HorizontalLayout();
            userInfoLayout.add(userIcon);
            userInfoLayout.setVerticalComponentAlignment(Alignment.CENTER, userIcon);

            VerticalLayout postLayout = new VerticalLayout();
            postLayout.add(userInfoLayout, postImage, caption, likeButton, commentButton);
            postLayout.getStyle().set("border", "20px solid white");

            Div centeringDiv = new Div(postLayout);
            centeringDiv.getStyle().set("margin", "auto");



            add(centeringDiv);

            setJustifyContentMode(JustifyContentMode.CENTER);
            getStyle().set("background-color", "#C19A6B");
        }
    }
}







