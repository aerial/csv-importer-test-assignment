package com.company.csvimporter.filesystem;

import com.company.csvimporter.service.UserImportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@Slf4j
public class FileProcessor {

    private final ResourceLoader resourceLoader;
    private final UserImportService userImportService;
    private final FileValidator fileValidator;

    public FileProcessor(ResourceLoader resourceLoader, UserImportService userImportService, FileValidator fileValidator) {
        this.resourceLoader = resourceLoader;
        this.userImportService = userImportService;
        this.fileValidator = fileValidator;
    }

    public void process(String fileName) throws IOException {
            File file = toFile(fileName);
            userImportService.importUsersFromFile(file);
    }

    private File toFile(String fileName) throws IOException {
        Resource resource = resourceLoader.getResource(fileName);
        File file = resource.getFile();
        fileValidator.validate(file);
        return file;
    }
}
