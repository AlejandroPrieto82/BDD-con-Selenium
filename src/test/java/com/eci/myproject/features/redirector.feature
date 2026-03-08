@redirector
Feature: Redirector on The Internet

  Scenario: Redirect from redirector page to status codes page
    Given I am on the redirector page
    When I click the redirect link
    Then I should be redirected to the status codes page