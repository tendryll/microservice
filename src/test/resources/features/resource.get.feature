Feature: The GET /resource/{id} endpoint is responsible for retrieving resource details.

  As a REST client, I want to call a REST service so that I can get the details of a resource.

  Background:
    Given the endpoint of "/resource"

  Scenario: Request for resource details results in a successful response
    Given an id of 1
    When the GET REST endpoint has been called
    Then a resource is returned with an id = 1
    And a name = "Effective Java (Java Series)"
    And a description = "Are you looking for a deeper understanding of the Java™ programming language?"
    And a status code of 200 is returned

  Scenario: Request for resource details results in a 404 Not Found error
    Given an id of 2
    When the GET REST endpoint has been called
    Then an error response is returned with a message of "Resource not found."
    And a status code of 404 is returned