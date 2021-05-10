Feature:  GitHub API functionality

  Background:
    Given User landed to Github page

  @api
  Scenario: API returns correct full name
    And user pass a username as "PhotoBox"
    When I GET request to "users/{username}"
    Then response status code should be 200
    And I verify name as a "PhotoBox"