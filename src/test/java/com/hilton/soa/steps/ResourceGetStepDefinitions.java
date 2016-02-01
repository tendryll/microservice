package com.hilton.soa.steps;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.JerseyClientBuilder;
import com.hilton.soa.RunCukesIT;
import com.hilton.soa.model.AppError;
import com.hilton.soa.model.Resource;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class ResourceGetStepDefinitions {
  private String endpoint;
  private Integer id;
  private Resource _resource;
  private AppError _error;
  private int statusCode;

  @Given("^the endpoint of \"([^\"]*)\"$")
  public void the_endpoint_of(final String endpoint) throws Throwable {
    this.endpoint = endpoint;
  }

  @Given("^an id of (\\d+)$")
  public void an_id_of(final Integer id) throws Throwable {
    this.id = id;
  }

  @When("^the REST endpoint has been called$")
  public void the_REST_endpoint_has_been_called() throws Throwable {
    final String url = String.format("http://localhost:%d%s/%d", RunCukesIT.RULE.getLocalPort(), endpoint, id);
    final Client client = new JerseyClientBuilder().build();
    final Response response = client.target(url).request().get();

    statusCode = response.getStatus();

    if (response.getStatus() == Response.Status.OK.getStatusCode()) {
      _resource = response.readEntity(Resource.class);
    } else if (response.getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
      _error = response.readEntity(AppError.class);
    }
  }

  @Then("^a resource is returned with an id = (\\d+)$")
  public void a_resource_is_returned_with_an_id(final Integer id) throws Throwable {
    assertEquals(id, _resource.getId());
  }

  @Then("^a name = \"([^\"]*)\"$")
  public void a_name(final String name) throws Throwable {
    assertEquals(name, _resource.getName());
  }

  @Then("^a description = \"([^\"]*)\"$")
  public void a_description(final String description) throws Throwable {
    assertEquals(description, _resource.getDescription());
  }

  @Then("^an error response is returned with a message of \"([^\"]*)\"$")
  public void an_error_response_is_returned_with_a_message_of(String msg) throws Throwable {
    assertEquals(msg, _error.getMsg());
  }

  @Then("^a status code of (\\d+)$")
  public void the_http_header_status_code_of_is_returned(int statusCode) throws Throwable {
    assertEquals(statusCode, this.statusCode);
  }
}
