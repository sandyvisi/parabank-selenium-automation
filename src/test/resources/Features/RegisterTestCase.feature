Feature: test the feature file

  @smokeTest
  Scenario Outline: check user can able to register
    Given user landed to register page of parabank
    When enter all of the user's details to register "<firstName>" "<lastName>" "<address>" "<city>" "<state>" "<zipcode>" "<phoneNumber>" "<ssnNumber>" "<userName>" "<password>" "<repeatPassword>"
    Then user validated the function

    Examples:
      | firstName | lastName | address | city        | state     | zipcode | phoneNumber | ssnNumber | userName         | password   | repeatPassword |
      | santhosh  | kumar    | #35 hsd | natrampalli | tamilnadu | 635852  | 3242323432  | 34223324  | sandysaisanthosh | Saibaba1@3 | Saibaba1@3     |
