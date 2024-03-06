Feature: Successful Login
  As a JIRA user
  I want to log in to the JIRA page
  So that I can use the JIRA website

  Scenario: User logs in successfully
    Given I am on the login page
    When I enter valid credentials
    Then I should be logged in successfully
