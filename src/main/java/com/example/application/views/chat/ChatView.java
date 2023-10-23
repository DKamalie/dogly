package com.example.application.views.chat;

import com.example.application.views.MainLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PageTitle("Connections")
@Route(value = "connection", layout = MainLayout.class)
@PermitAll
public class ChatView {
}
