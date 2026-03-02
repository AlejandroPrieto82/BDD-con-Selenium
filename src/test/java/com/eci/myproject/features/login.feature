Feature: Login on The Internet

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter username "tomsmith" and password "SuperSecretPassword!"
    Then I should see a success message

  Scenario: Failed login with invalid credentials
    Given I am on the login page
    When I enter username "wronguser" and password "wrongpass"
    Then I should see an error message
    