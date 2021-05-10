Feature: GitHub UI functionality

  Background:
    Given User landed to Github

  @web
  Scenario: UI shows correct availability of a username
    And user click Sign up button
    When user types "PhotoBox" as user name
    Then user should get user not available message
    And UI shows correct availability of username

  Scenario Outline: UI shows correct availability of a username with DDT
    And user click Sign up button
    When user types "<userName>" as user name
    Then user should get user not available message
    And UI shows correct availability of username

    Examples:
      | userName  |
      | PhotoBox  |
      | PhotoBox1 |
      | PhotoBox2 |