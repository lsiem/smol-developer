```java
package com.vicreator.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vicreator.service.UserService;

@Route("register")
public class RegistrationView extends VerticalLayout {

    private final UserService userService;

    private TextField usernameField = new TextField("Username");
    private PasswordField passwordField = new PasswordField("Password");
    private Button registerButton = new Button("Register");

    public RegistrationView(UserService userService) {
        this.userService = userService;
        FormLayout registrationForm = new FormLayout();
        registrationForm.add(usernameField, passwordField, registerButton);
        add(registrationForm);
        registerButton.addClickListener(e -> register());
    }

    private void register() {
        String username = usernameField.getValue();
        String password = passwordField.getValue();

        if (userService.register(username, password)) {
            Notification.show("Registration successful. Please login.");
        } else {
            Notification.show("Registration failed. Please try again.");
        }
    }
}
```