# MultiContainerized Application for Test Automation with Allure Reporting
This project aims to enable the execution of test runners (Selenium, RestAssured, and experimentally Playwright) through Docker. The solution consists of a docker-compose setup capable of running tests defined in Gherkin without additional dependencies, providing high portability and ease of use.

## Prerequisites

- Docker
- Docker Compose

## Project Structure

- `docker-compose.yml`: Docker Compose configuration file to set up Selenium Grid, Chrome and Firefox nodes, and Allure reporting service.
- `src/test/java`: Directory containing your test classes and test suite XML file.

## Setup

1. **Clone the repository**:
   ```sh
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Build and start the services**:

    ```sh
    docker-compose up --build
    ```

3. **Run you test**:
    ```sh
    docker-compose up --no-deps test-runner
    ```

## Running Tests
The test-runner service in the docker-compose.yml file is configured to run your tests using Maven. It will execute the tests defined in the src/test/java/runners/runner.xml file.

## Viewing Allure Reports
After the tests have been executed, you can view the Allure report by navigating to http://localhost:4040 in your web browser.

## Configuration
Selenium Hub: The central component of Selenium Grid.
Chrome and Firefox Nodes: Browser nodes that connect to the Selenium Hub.
Test Runner: A Maven container that runs the tests.
Allure: A service to generate and serve Allure reports.

## Additional Information
Volumes: The docker-compose.yml file includes volumes for allure-results and allure-reports to store test results and reports.
Plugins: The pom.xml file includes the maven-cucumber-reporting plugin to generate Cucumber HTML reports.
Environment Variables: The docker-compose.yml file sets environment variables for the browser and Selenium Hub host.
TestNG Configuration: The src/test/java/runners/runner.xml file configures TestNG with Allure reporting.
Screenshot Utility: The project includes a ScreenshotUtil class to capture screenshots on test failure.

## Experimental Playwright Runner
In addition to Selenium and RestAssured, it is also possible to run tests using an experimental runner for Playwright. This allows for cross-browser testing with a modern automation framework.
