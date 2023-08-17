```java
package com.vicreator.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vicreator.service.AuthenticationService;

@Route("login")
public class LoginView extends VerticalLayout {

    private AuthenticationService authenticationService;

    public LoginView(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;

        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(e -> {
            boolean isAuthenticated = authenticationService.authenticate(e.getUsername(), e.getPassword());
            if (isAuthenticated) {
                loginForm.getUI().ifPresent(ui -> ui.navigate("main"));
            } else {
                loginForm.setError(true);
            }
        });

        Button registerButton = new Button("Register", e -> {
            loginForm.getUI().ifPresent(ui -> ui.navigate("register"));
        });

        add(loginForm, registerButton);
    }
}
```