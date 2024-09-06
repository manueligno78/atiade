@playwright @CloudAcademy @End2End
Feature: Basic Cloud Academy End to End Test

    @search @allure.label.layer:web @allure.label.owner:manuel @normal
    Scenario Outline: User can search for a course
    User can search for a course by typing in the search bar
    Given I am on the Cloud Academy home page
    When I search for "<query>"
    Then I should see a list of courses related to "<expected_result>"
        Examples:
        | query  | expected_result  |
        | AWS    | AWS              |
        | GCP    | Google Cloud     |
        | Azure  | Azure            |
      