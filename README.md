### A test assignment project for importing users from CSV file

##### Libraries\Frameworks used: 
* Spring Boot 2
* Spring Data JPA
* In-memory H2SQL database
* Hibernate
* Apache Commons Csv
* AssertJ
* Junit 5
 
##### Description:
This application accepts a filename as a command-line argument and imports data into a database table. A file should be a proper(see CSV structure section) CSV file with correct data. File size should not exceed 1 MB.
 
##### CSV structure:
Application accepts only CSV files with following headers: Email, FirstName, LastName, FiscalCode, Description, LastAccessDate

##### How to run: 
Simply run mvn `spring-boot:run your-filename.csv` inside the project root directory. Or run CsvImporterApplication directly from IDE(do not forget the command-line argument).

##### How to run tests: 
Run `mvn test` inside the project root directory.
 
##### Comments
* A combination of Spring Data JPA + Hibernate is selected for this particular task because there is a requirement for being independent of storage and DB((Keep in mind the storage provider could change)
* This task could also be accomplished with ability to upload multipart files via Rest API, using Spring MockMVC for testing, but a command-line approach was selected for simplicity.
* Selecting of an appropriate CSV parser was most time-consuming and complex :) 
* Time spent ~2.5 hours  
