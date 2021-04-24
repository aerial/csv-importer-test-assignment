package com.company.csvimporter.service;

import com.company.csvimporter.domain.User;
import com.company.csvimporter.importer.FileUserReader;
import com.company.csvimporter.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class UserImportService {

    private final FileUserReader reader;
    private final UserRepository userRepository;

    public UserImportService(FileUserReader reader, UserRepository userRepository) {
        this.reader = reader;
        this.userRepository = userRepository;
    }

    public void importUsersFromFile(File file) {
        List<User> users = reader.readAll(file);
        for (User user : users) {
            userRepository.save(user);
        }
    }
}
