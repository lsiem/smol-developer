```java
package com.vicreator.service;

import com.vicreator.model.File;
import com.vicreator.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public File storeFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();

        try {
            File dbFile = new File(fileName, file.getContentType(), file.getBytes());
            return fileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public File getFile(String fileId) {
        return fileRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found with id " + fileId));
    }
}
```