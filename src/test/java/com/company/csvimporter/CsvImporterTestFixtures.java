package com.company.csvimporter;

import com.company.csvimporter.domain.User;

import java.time.LocalDate;

public class CsvImporterTestFixtures {
    public static final String VALID_FILE = "classpath:valid.csv";
    public static final String INVALID_FILE = "classpath:invalid.csv";
    public static final String OVERWRITE_JOHN = "classpath:overwrite_john.csv";
    public static final String BIG_FILE = "classpath:big_file.csv";
    public static final String NOT_CSV_FILE = "classpath:file.txt";


    public static final String USER_1_EMAIL = "test1@test.com";
    public static final String USER_1_FIRST_NAME = "John";
    public static final String USER_1_LAST_NAME = "Doe";
    public static final String USER_1_FISCAL_CODE = "AAAA1";
    public static final String USER_1_OVERWRITTEN_FISCAL_CODE = "AAAA1_v2";
    public static final String USER_1_DESCRIPTION = "This is John Doe";
    public static final String USER_1_OVERWRITTEN_DESCRIPTION = "This is John Doe_v2";
    public static final LocalDate USER_1_LAST_ACCESS_DATE = LocalDate.parse("2021-01-01");
    public static final User USER_1 = new User(USER_1_EMAIL,
            USER_1_FIRST_NAME,
            USER_1_LAST_NAME,
            USER_1_FISCAL_CODE,
            USER_1_DESCRIPTION,
            USER_1_LAST_ACCESS_DATE);

    public static final String USER_2_EMAIL = "test2@test.com";
    public static final String USER_2_FIRST_NAME = "Mary";
    public static final String USER_2_LAST_NAME = "Jane";
    public static final String USER_2_FISCAL_CODE = "AAAA2";
    public static final String USER_2_DESCRIPTION = "This is Mary Jane";
    public static final LocalDate USER_2_LAST_ACCESS_DATE = LocalDate.parse("2021-01-02");
    public static final User USER_2 = new User(USER_2_EMAIL,
            USER_2_FIRST_NAME,
            USER_2_LAST_NAME,
            USER_2_FISCAL_CODE,
            USER_2_DESCRIPTION,
            USER_2_LAST_ACCESS_DATE);
}

