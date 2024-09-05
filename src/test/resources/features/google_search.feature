@sanity
Feature: Google Search
  Scenario: Verify Google search box
    Given I open Google homepage
    Then I should see the search box
  
  Scenario: Verify Google search box 2
    Given I open Google homepage
    Then I should see the search box

  Scenario: Verify Google search box (ko simulation with assert false)
    Given I open Google homepage
    Then I should assert false