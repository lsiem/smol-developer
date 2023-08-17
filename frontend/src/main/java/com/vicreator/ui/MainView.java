```java
package com.vicreator.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

@Route("")
@PageTitle("ViCreator | Home")
public class MainView extends VerticalLayout {

    private Button registerButton;
    private Button loginButton;

    public MainView() {
        addClassName("main-view");

        registerButton = new Button("Register", event -> registerButton.getUI().ifPresent(ui -> ui.navigate("register")));
        loginButton = new Button("Login", event -> loginButton.getUI().ifPresent(ui -> ui.navigate("login")));

        add(registerButton, loginButton);
    }
}
```