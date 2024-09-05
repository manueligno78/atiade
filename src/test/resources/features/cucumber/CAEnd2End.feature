@CloudAcademy @End2End
Feature: Basic Cloud Academy End to End Test

    @search
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


     Scenario: User can pay for a subscription plan
     User move to pricing page, select the Small teams pricing plan and land on the payment page
     WARNING: This test is not fully automated because of AB testing in place on the target page
     Given I am on the Cloud Academy home page
     When I click on the pricing link
     Then I land on the pricing page
     Then all pricing plans should be visible
     When I click on the Start Now button for the Small Teams plan
     Then I expect to land on the payment page
     #And I should see all the required fields to fill in the form
     #Seems that on target page there is an AB testing in place, so I can't see the form fields every time and I can't automate this step
 