Feature: The POST /resource/{id} endpoint is responsible for creating resource details.

  As a REST client, I want to call a REST service so that I can create resource details.

  Background:
    Given the endpoint of "/resource"

  Scenario: Request to add resource details results in a successful response
    Given a name of "BDD in Action"
    And a description of "BDD in Action teaches you the Behavior-Driven Development model and shows you"
    When the POST REST endpoint has been called
    Then a status code of 201 is returned

  Scenario: Request to add a resource results in a 422 Unprocessable Entity (WebDAV) when the name is not provided
    When the POST REST endpoint has been called
    Then a status code of 422 is returned