```java
package com.vicreator.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vicreator.service.RenderService;

@Route("render")
public class RenderView extends VerticalLayout {

    private final RenderService renderService;

    public RenderView(RenderService renderService) {
        this.renderService = renderService;

        Button renderButton = new Button("Render Movie");
        renderButton.addClickListener(e -> {
            try {
                renderService.renderMovie();
                Notification.show("Movie rendering started. You will be notified when it's done.");
            } catch (Exception ex) {
                Notification.show("Error while starting movie rendering: " + ex.getMessage());
            }
        });

        add(renderButton);
    }
}
```