package com.company.csvimporter.importer;

import com.company.csvimporter.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class CsvFileUserReader implements FileUserReader {

    @Override
    public List<User> readAll(File file)  {
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            List<User> users = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord record : csvRecords) {
                User user = new User(
                        record.get("Email"),
                        record.get("FirstName"),
                        record.get("LastName"),
                        record.get("FiscalCode"),
                        record.get("Description"),
                        LocalDate.parse(record.get("LastAccessDate"))
                );
                users.add(user);
            }
            return users;
        } catch (IOException e) {
            log.error("Unable to read user list from file: {}", file);
        }
        return Collections.EMPTY_LIST;
    }

}
