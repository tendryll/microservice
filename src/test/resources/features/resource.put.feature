Feature: The PUT /resource/{id} endpoint is responsible for updating resource details.

  As a REST client, I want to call a REST service so that I update resource details.

  Background:
    Given the endpoint of "/resource"

  Scenario: Request to update resource details results in a successful response
    Given an id of 1
    And a name of "Docker: Up & Running, 1st Edition"
    And a description of "Docker is quickly changing the way that organizations are deploying software at scale."
    When the PUT REST endpoint has been called
    Then a status code of 204 is returned

  Scenario: Request to update a resource results in a 422 Unprocessable Entity (WebDAV) when the name is not provided
    Given an id of 1
    When the PUT REST endpoint has been called
    Then a status code of 422 is returned

  Scenario: Request to update resource details results in a 404 Not Found when the
    Given an id of 999
    When the PUT REST endpoint has been called
    Then a status code of 422 is returned