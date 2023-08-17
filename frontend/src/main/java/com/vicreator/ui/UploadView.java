```java
package com.vicreator.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vicreator.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;

public class UploadView extends VerticalLayout {

    private FileService fileService;

    @Autowired
    public UploadView(FileService fileService) {
        this.fileService = fileService;

        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.setMaxFiles(1);
        upload.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");

        Button uploadButton = new Button("Upload", event -> {
            try {
                fileService.storeFile(buffer.getInputStream(), buffer.getFileName());
                Notification.show("File uploaded successfully!", 3000, Notification.Position.MIDDLE);
            } catch (Exception e) {
                Notification.show("Error uploading file: " + e.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        });

        Div output = new Div(new Label("Upload an image to start creating your movie."));
        output.setSizeFull();

        add(upload, uploadButton, output);
    }
}
```