package com.company.csvimporter;

import com.company.csvimporter.filesystem.FileProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CsvImporterApplication implements CommandLineRunner {

	private final FileProcessor fileProcessor;

	public CsvImporterApplication(FileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}

	public static void main(String[] args) {
		SpringApplication.run(CsvImporterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Received application command line arguments: {}", args);
		if (args.length == 0) {
			throw new IllegalArgumentException("At least one argument should be provided");
		}
		fileProcessor.process(args[0]);
	}
}
