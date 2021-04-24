package com.company.csvimporter;

import com.company.csvimporter.domain.User;
import com.company.csvimporter.filesystem.FileProcessor;
import com.company.csvimporter.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(args = CsvImporterTestFixtures.VALID_FILE)
class CsvImporterApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FileProcessor fileProcessor;

	@Test
	void givenValidCsvIsProvided_thenAllUsersShouldBeSavedToDB() {
		Iterable<User> users = userRepository.findAll();
		assertThat(users).hasSize(2);

		assertThat(users).extracting("email")
				.contains(CsvImporterTestFixtures.USER_1_EMAIL, CsvImporterTestFixtures.USER_2_EMAIL);

		assertThat(users).extracting("firstName")
				.contains(CsvImporterTestFixtures.USER_1_FIRST_NAME, CsvImporterTestFixtures.USER_2_FIRST_NAME);

		assertThat(users).extracting("lastName")
				.contains(CsvImporterTestFixtures.USER_1_LAST_NAME, CsvImporterTestFixtures.USER_2_LAST_NAME);

		assertThat(users).extracting("fiscalCode")
				.contains(CsvImporterTestFixtures.USER_1_FISCAL_CODE, CsvImporterTestFixtures.USER_1_FISCAL_CODE);

		assertThat(users).extracting("description")
				.contains(CsvImporterTestFixtures.USER_1_DESCRIPTION, CsvImporterTestFixtures.USER_2_DESCRIPTION);

		assertThat(users).extracting("lastAccessDate")
				.contains(CsvImporterTestFixtures.USER_1_LAST_ACCESS_DATE, CsvImporterTestFixtures.USER_2_LAST_ACCESS_DATE);

	}

	@Test
	void givenUserAlreadyInDB_whenNewDataIsImportedWithSameEmail_thenUserDataIsOverwritten() {
		//load one more file with updated data
		CsvImporterApplication.main(new String[]{CsvImporterTestFixtures.OVERWRITE_JOHN});
		//check if data for first user was updated
		User john = userRepository.findByEmail(CsvImporterTestFixtures.USER_1_EMAIL).get();
		assertEquals(CsvImporterTestFixtures.USER_1_OVERWRITTEN_FISCAL_CODE, john.getFiscalCode());
		assertEquals(CsvImporterTestFixtures.USER_1_OVERWRITTEN_DESCRIPTION, john.getDescription());
	}

	@Test
	void givenFileMoreThan1MB_thenAnExceptionShouldBeThrown() {
		Assertions.assertThrows(UnsupportedOperationException.class, () -> fileProcessor.process(CsvImporterTestFixtures.BIG_FILE));
	}

	@Test
	void givenNotACsvFile_thenAnExceptionShouldBeThrown() {
		Assertions.assertThrows(UnsupportedOperationException.class, () -> fileProcessor.process(CsvImporterTestFixtures.NOT_CSV_FILE));
	}

}
