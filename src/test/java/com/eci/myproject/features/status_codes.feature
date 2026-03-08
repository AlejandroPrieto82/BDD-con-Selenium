@status_codes
Feature: Status Codes on The Internet

  Scenario Outline: Verify HTTP status code pages
    Given I am on the status codes page
    When I click on status code "<code>"
    Then I should see the status code "<code>" in the page

    Examples:
      | code |
      | 200  |
      | 301  |
      | 404  |
      | 500  |