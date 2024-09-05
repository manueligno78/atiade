@rickyandmorty
Feature: Ricky And Morty API Testing
Using the documentation of the attached API: https://rickandmortyapi.com/
Test both the Rest API/character and the GraphQL calls, asserting:
• Status code;
• Body response;
• Latency below 1 second;
• Test correct negative cases

  Scenario: Test Rest API /character status code
    Given the Rest API endpoint "/character"
    When I send a GET request
    Then the status code should be 200

  Scenario: Test Rest API /character body response
    Given the Rest API endpoint "/character"
    When I send a GET request
    Then the response body should contain "results"

  Scenario: Test Rest API /character latency
    Given the Rest API endpoint "/character"
    When I send a GET request
    Then the response time should be less than 1 second

  Scenario: Test Rest API /character negative case
    Given the Rest API endpoint "/character/999999"
    When I send a GET request
    Then the status code should be 404

  Scenario: Test GraphQL status code
    Given the GraphQL endpoint
    And the query "{ characters { results { name } } }"
    When I send a POST request
    Then the status code should be 200

  Scenario: Test GraphQL body response
    Given the GraphQL endpoint
    And the query "{ characters { results { name } } }"
    When I send a POST request
    Then the response body should contain "data"

  Scenario: Test GraphQL latency
    Given the GraphQL endpoint
    And the query "{ characters { results { name } } }"
    When I send a POST request
    Then the response time should be less than 1 second

  Scenario: Test GraphQL negative case
    Given the GraphQL endpoint
    And the query "{ character(id: 999999) { name } }"
    When I send a POST request
    Then the status code should be 200
    And the response body should contain "null" for "data.character"