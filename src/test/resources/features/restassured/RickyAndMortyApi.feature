@rickyandmorty @restassured @ca-exam
@normal
Feature: Ricky And Morty API Testing
Using the documentation of the attached API: https://rickandmortyapi.com/
Test both the Rest API/character and the GraphQL calls, asserting:
• Status code;
• Body response;
• Latency below 1 second;
• Test correct negative cases
  @rest
  Scenario: Test Rest API /character status code
    Test the status code of the API response in happy path scenario
    Given the Rest API endpoint "/character"
    When I send a GET request
    Then the status code should be 200

  @rest
  Scenario: Test Rest API /character body response
    Test the content of the API response
    Given the Rest API endpoint "/character"
    When I send a GET request
    Then the response body should contain "results"

  @rest
  Scenario: Test Rest API /character latency
    Test the latency of the API response
    Given the Rest API endpoint "/character"
    When I send a GET request
    Then the response time should be less than 1 second

  @rest
  Scenario: Test Rest API /character negative case
    Test the negative case of the API response
    Given the Rest API endpoint "/character/999999"
    When I send a GET request
    Then the status code should be 404

  @graphql
  Scenario: Test GraphQL status code
    Test the status code of the GraphQL response in happy path scenario
    Given the GraphQL endpoint
    And the query "{ characters { results { name } } }"
    When I send a POST request
    Then the status code should be 200

  @graphql
  Scenario: Test GraphQL body response
    Test the content of the GraphQL response
    Given the GraphQL endpoint
    And the query "{ characters { results { name } } }"
    When I send a POST request
    Then the response body should contain "data"

  @graphql
  Scenario: Test GraphQL latency
    Test the latency of the GraphQL response
    Given the GraphQL endpoint
    And the query "{ characters { results { name } } }"
    When I send a POST request
    Then the response time should be less than 1 second

  @graphql
  Scenario: Test GraphQL negative case
    Test the negative case of the GraphQL response
    Given the GraphQL endpoint
    And the query "{ character(id: 999999) { name } }"
    When I send a POST request
    Then the status code should be 200
    And the response body should contain "null" for "data.character"