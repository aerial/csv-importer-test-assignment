package com.company.csvimporter.filesystem;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class CsvFileValidator implements FileValidator {

    @Override
    public void validate(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("File: %s not found", file.getName()));
        }
        if (!file.getName().endsWith(".csv")) {
            throw new UnsupportedOperationException("Only CSV files are supported at the moment");
        }
        if (file.length() / 1024 > 1024) {
            throw new UnsupportedOperationException("Only files less than 1MB are supported at the moment");
        }
    }
}
