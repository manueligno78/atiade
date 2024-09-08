@cucumber @sanity
Feature: Google Search
  @blocker
  Scenario: Verify Google search box
    Given I open Google homepage
    Then I should see the search box

  @trivial @ko
  Scenario: Verify Google search box (ko simulation with assert false)
    Given I open Google homepage
    Then I should assert false