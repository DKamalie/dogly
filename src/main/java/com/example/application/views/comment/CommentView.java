package com.example.application.views.comment;

import com.example.application.views.MainLayout;
import com.example.application.websocket.ChatComponent;
import com.example.application.websocket.ChatMessage;
import com.example.application.websocket.MessageReceiver;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.Arrays;
import java.util.List;

@PageTitle("Comment Section")
@Route(value = "comment", layout = MainLayout.class)
@AnonymousAllowed
public class CommentView extends Div implements AfterNavigationObserver{
    Grid<Person> grid = new Grid<>();
    public CommentView() {
        addClassName("card-list-view");
        setSizeFull();
        grid.setHeight("100%");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn(person -> createCard(person));
        add(grid);
    }

    private HorizontalLayout createCard(Person person) {
        HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");

        Image image = new Image();
        image.setSrc(person.getImage());
        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        Span name = new Span(person.getName());
        name.addClassName("name");
        Span date = new Span(person.getDate());
        date.addClassName("date");
        header.add(name, date);

        Span post = new Span(person.getPost());
        post.addClassName("post");

        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");

        Icon likeIcon = VaadinIcon.HEART.create();
        likeIcon.addClassName("icon");
        Span likes = new Span(person.getLikes());
        likes.addClassName("likes");
        Icon commentIcon = VaadinIcon.COMMENT.create();
        commentIcon.addClassName("icon");
        Span comments = new Span(person.getComments());
        comments.addClassName("comments");
        Icon shareIcon = VaadinIcon.CONNECT.create();
        shareIcon.addClassName("icon");
        Span shares = new Span(person.getShares());
        shares.addClassName("shares");

        actions.add(likeIcon, likes, commentIcon, comments, shareIcon, shares);

        description.add(header, post, actions);
        card.add(image, description);
        return card;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {

        // Set some data when this view is displayed.
        List<Person> persons = Arrays.asList(
                createPerson("https://randomuser.me/api/portraits/men/42.jpg", "John Smith", "May 8",
                        "I can't resist those wagging tails and wet noses! Dogs bring so much joy into my life. 🐾❤️",
                        "3K", "700", "50"),
                createPerson("https://randomuser.me/api/portraits/women/42.jpg", "Abagail Libbie", "May 3",
                        "Every day is a 'paw'sitive day when you have a furry friend by your side! 🐶✨",
                        "2K", "600", "45"),
                createPerson("https://randomuser.me/api/portraits/men/24.jpg", "Alberto Raya", "May 3",
                        "Dog kisses and tail wags make my heart skip a beat. Life is better with a dog! 🐕💖",
                        "4K", "800", "60"),
                createPerson("https://randomuser.me/api/portraits/women/24.jpg", "Emmy Elsner", "Apr 22",
                        "In a world full of ordinary things, I'm grateful for the extraordinary love of my dog! 🐾❤️",
                        "6K", "1200", "90"),
                createPerson("https://randomuser.me/api/portraits/men/76.jpg", "Alf Huncoot", "Apr 21",
                        "My dog is not just a pet; he's family. We share countless adventures and endless love! 🐶💕",
                        "3K", "700", "50"),
                createPerson("https://randomuser.me/api/portraits/women/76.jpg", "Lidmila Vilensky", "Apr 17",
                        "There's no love purer than the love of a dog. My furry companion fills my days with happiness! 🐕😊",
                        "6K", "1200", "90"),
                createPerson("https://randomuser.me/api/portraits/men/94.jpg", "Jarrett Cawsey", "Apr 17",
                        "Dogs teach us loyalty, patience, and the true meaning of unconditional love. Forever grateful for my furry friend! 🐾❤️",
                        "6K", "1200", "90"),
                createPerson("https://randomuser.me/api/portraits/women/94.jpg", "Tania Perfilyeva", "Mar 8",
                        "Life is 'paw'sitively amazing with a dog by your side. Here's to endless cuddles and wagging tails! 🐶💫",
                        "3K", "700", "50"),
                createPerson("https://randomuser.me/api/portraits/men/16.jpg", "Ivan Polo", "Mar 5",
                        "My dog isn't just a pet; he's my best friend, confidant, and partner in crime. Together, we navigate life's adventures! 🐾🌟",
                        "6K", "1200", "90"),
                createPerson("https://randomuser.me/api/portraits/women/16.jpg", "Emelda Scandroot", "Mar 5",
                        "In the presence of a dog, life's struggles melt away. Grateful for the unconditional love and endless joy my furry friend brings! 🐶❤️",
                        "2K", "600", "45"),
                createPerson("https://randomuser.me/api/portraits/men/67.jpg", "Marcos Sá", "Mar 4",
                        "Dogs have a unique way of finding the way to your heart. My dog's paw prints are forever imprinted on my soul! 🐾💖",
                        "6K", "1200", "90"),
                createPerson("https://randomuser.me/api/portraits/women/67.jpg", "Jacqueline Asong", "Mar 2",
                        "There's nothing more heartwarming than a dog's love. Each wag of the tail reminds us of the simple joys in life! 🐾😊",
                        "4K", "800", "60")
        );


        grid.setItems(persons);
    }

    private static Person createPerson(String image, String name, String date, String post, String likes,
                                       String comments, String shares) {
        Person p = new Person();
        p.setImage(image);
        p.setName(name);
        p.setDate(date);
        p.setPost(post);
        p.setLikes(likes);
        p.setComments(comments);
        p.setShares(shares);

        return p;
    }

}