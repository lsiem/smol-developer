```java
package com.vicreator.service;

import com.vicreator.model.File;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class RenderService {

    private final String RENDER_COMMAND = "ffmpeg -r 1/5 -i img%03d.png -c:v libx264 -vf fps=25 -pix_fmt yuv420p output.mp4";

    public void render(File file) {
        try {
            Process process = Runtime.getRuntime().exec(RENDER_COMMAND);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```