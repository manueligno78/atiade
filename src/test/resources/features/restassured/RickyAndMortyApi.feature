@rickyandmorty @restassured @ca-exam
@normal
Feature: Ricky And Morty API Testing
Using the documentation of the attached API: https://rickandmortyapi.com/
Test both the Rest API/character and the GraphQL calls, asserting:
• Status code;
• Body response;
• Latency below 1 second;
• Test correct negative cases
  @rest @get-single-character
  Scenario: Test Rest API /character status code
    Test the status code of the API response in happy path scenario
    Given the Rest API endpoint "/character"
    When I send a GET request
    Then the status code should be 200

  @rest @get-single-character
  Scenario: Test Rest API /character body response
    Test the content of the API response
    Given the Rest API endpoint "/character"
    When I send a GET request
    Then the response body should contain "results"

  @rest @get-single-character
  Scenario: Test Rest API /character latency
    Test the latency of the API response
    Given the Rest API endpoint "/character"
    When I send a GET request
    Then the response time should be less than 1 second

  @rest @get-single-character
  Scenario: Test Rest API /character negative case
    Test the negative case of the API response
    Given the Rest API endpoint "/character/999999"
    When I send a GET request
    Then the status code should be 404

  @rest @get-all-character
  Scenario: Test Rest API get all characters
    Test the retrieval of all characters
    Given the Rest API endpoint "/character"
    When I send a GET request
    Then the response body should contain "results"
    And the status code should be 200

  @rest @get-multiple-character
  Scenario: Test Rest API get multiple characters
    Test the retrieval of multiple characters
    Given the Rest API endpoint "/character/1,2,3"
    When I send a GET request
    Then the response body should contain "Rick Sanchez"
    And the response body should contain "Morty Smith"
    And the response body should contain "Summer Smith"
    And the status code should be 200

  @rest @get-multiple-character @filtering
  Scenario: Test Rest API filter characters by name
    Test the filtering of characters by name
    Given the Rest API endpoint "/character?name=Rick"
    When I send a GET request
    Then the response body should contain "Rick Sanchez"
    And the status code should be 200

  @rest @get-multiple-character @filtering
  Scenario: Test Rest API filter characters by status
    Test the filtering of characters by status
    Given the Rest API endpoint "/character?status=alive"
    When I send a GET request
    Then the response body should contain "Alive"
    And the status code should be 200

  @graphql @get-single-character
  Scenario: Test GraphQL status code
    Test the status code of the GraphQL response in happy path scenario
    Given the GraphQL endpoint
    And the query "{ characters { results { name } } }"
    When I send a POST request
    Then the status code should be 200

  @graphql @get-single-character
  Scenario: Test GraphQL body response
    Test the content of the GraphQL response
    Given the GraphQL endpoint
    And the query "{ characters { results { name } } }"
    When I send a POST request
    Then the response body should contain "data"

  @graphql @get-single-character
  Scenario: Test GraphQL latency
    Test the latency of the GraphQL response
    Given the GraphQL endpoint
    And the query "{ characters { results { name } } }"
    When I send a POST request
    Then the response time should be less than 1 second

  @graphql @get-single-character
  Scenario: Test GraphQL negative case
    Test the negative case of the GraphQL response
    Given the GraphQL endpoint
    And the query "{ character(id: 999999) { name } }"
    When I send a POST request
    Then the status code should be 200
    And the response body should contain "null" for "data.character"
  
  @graphql @get-all-character
  Scenario: Test GraphQL get all characters
    Test the retrieval of all characters using GraphQL
    Given the GraphQL endpoint
    And the query "{ characters { results { name } } }"
    When I send a POST request
    Then the response body should contain "results"
    And the status code should be 200

  @graphql @get-multiple-character
  Scenario: Test GraphQL get multiple characters
    Test the retrieval of multiple characters using GraphQL
    Given the GraphQL endpoint
    And the query "{ charactersByIds(ids: [1, 2, 3]) { name } }"
    When I send a POST request
    Then the response body should contain "Rick Sanchez"
    And the response body should contain "Morty Smith"
    And the response body should contain "Summer Smith"
    And the status code should be 200