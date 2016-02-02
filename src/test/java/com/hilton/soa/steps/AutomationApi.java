package com.hilton.soa.steps;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.JerseyClientBuilder;
import com.hilton.soa.RunCukesTest;
import com.hilton.soa.model.AppError;
import com.hilton.soa.model.Resource;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class AutomationApi {
  public String endpoint;
  public Integer id;
  public String name;
  public String description;
  public Resource _resource;
  public AppError _error;
  public int statusCode;

  @Given("^the endpoint of \"([^\"]*)\"$")
  public void the_endpoint_of(final String endpoint) throws Throwable {
    this.endpoint = endpoint;
  }

  @Given("^an id of (\\d+)$")
  public void an_id_of(final Integer id) throws Throwable {
    this.id = id;
  }

  @Given("^a name of \"([^\"]*)\"$")
  public void a_name_of(final String name) throws Throwable {
    this.name = name;
  }

  @Given("^a description of \"([^\"]*)\"$")
  public void a_description_of(final String description) throws Throwable {
    this.description = description;
  }

  @Then("^a status code of (\\d+)$")
  public void a_status_code_of(int statusCode) throws Throwable {
    assertEquals(statusCode, this.statusCode);
  }

  @Then("^a status code of (\\d+) is returned$")
  public void a_status_code_of_is_returned(int statusCode) throws Throwable {
    a_status_code_of(statusCode);
  }

  @Then("^an error response is returned with a message of \"([^\"]*)\"$")
  public void an_error_response_is_returned_with_a_message_of(String msg) throws Throwable {
    assertEquals(msg, _error.getMsg());
  }
}
