Feature: The DELETE /resource/{id} endpoint is responsible for deleting a resource.

  As a REST client, I want to call a REST service so that I can get the details of a resource.

  Background:
    Given the endpoint of "/resource"

  Scenario: Request to delete resource details results in a successful response
    Given an id of 10
    When the DELETE REST endpoint has been called
    Then a status code of 204 is returned

  Scenario: Request to delete resource details results in a 404 Not Found error
    Given an id of 2
    When the GET REST endpoint has been called
    Then an error response is returned with a message of "Resource not found."
    And a status code of 404 is returned
