# Selenium Test Automation with Allure Reporting

This project demonstrates how to set up Selenium Grid with Chrome and Firefox nodes, run automated tests using Maven, and generate test reports using Allure.

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

## Running Tests
The test-runner service in the docker-compose.yml file is configured to run your tests using Maven. It will execute the tests defined in the src/test/java/runners/runner.xml file.

## Viewing Allure Reports
After the tests have been executed, you can view the Allure report by navigating to http://localhost:4040 in your web browser.

## Configuration
Selenium Hub: The central component of Selenium Grid.
Chrome and Firefox Nodes: Browser nodes that connect to the Selenium Hub.
Test Runner: A Maven container that runs the tests.
Allure: A service to generate and serve Allure reports.