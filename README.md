## deposityogeshdawkhar
Maven project to test User Functionality(i.e. add,get,delete) user. Using UI and REST APIs.

#### Technology used
- Maven : Building project
- Java 8 : Programming language 
- Selenium WebDriver(3.141.59) : Web automation framework 
- Rest Assured (3.2.0) : RESTful APIs automation
- Junit (4.12) : To write test cases 

#### Steps to run test

> Prerequisite
- Maven 
- Java 8 or higher 
- Firefox
- Chrome

#### Architectural points and Terminologies used in the project

There are two type of tests written within the project:
    
    1. UI Test (Using Selenium Webdriver)
    2. RESTful API Test (Using RestAssured)
    
    To build and check the result of the test, please throw following command in the terminal:
    
    > mvn clean install
	
 To view the Extent Report after test 

    {Workingdirectory}/deposityogeshdawkhar/src/ExtentReports/{currentTestExecutionfolder}/

> Comments in code 

Entire code styling is influenced by Clean Code principle - Robert Martin
Which says
'Truth can only be found in one place: the code’.
So you may not find any comments anywhere in the project.
Keeping in mind that git can be used to versioning of file and method, class names should be kept as self explanatory.

However, if you need comments on each file. I can do that too.

> Design principles used in Project :

- POM (Page Object Model)
- DRY(Don’t repeat yourself)
- KISS(Keep it simple, stupid)