```java
package com.vicreator.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

import java.io.InputStream;

@Route("editor")
public class ImageEditorView extends VerticalLayout {

    private Image image;
    private Button rotateButton;
    private Button saveButton;

    public ImageEditorView() {
        image = new Image();
        rotateButton = new Button("Rotate");
        saveButton = new Button("Save");

        rotateButton.addClickListener(event -> rotateImage());
        saveButton.addClickListener(event -> saveImage());

        add(image, rotateButton, saveButton);
    }

    public void setImage(InputStream imageStream, String filename) {
        StreamResource resource = new StreamResource(filename, () -> imageStream);
        image.setSrc(resource);
    }

    private void rotateImage() {
        // Call to JavaScript function to rotate image
        getElement().executeJs("rotateImage()");
    }

    private void saveImage() {
        // Call to backend service to save the edited image
    }
}
```