Feature: login to the parabank using the credentials

  Scenario Outline: Check login is successfull after registration
    Given user enters the login page
    When user enters "<userName>" "<password>"
    Then user is able to login propery

    Examples:
      | userName         | password   |
      | sandysaisanthosh | Saibaba1@3 |
