package com.company.csvimporter.importer;

import com.company.csvimporter.domain.User;

import java.io.File;
import java.util.List;

public interface FileUserReader {
    List<User> readAll(File file);
}
