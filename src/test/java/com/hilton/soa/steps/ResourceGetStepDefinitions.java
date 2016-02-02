package com.hilton.soa.steps;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.JerseyClientBuilder;
import com.hilton.soa.RunCukesTest;
import com.hilton.soa.model.AppError;
import com.hilton.soa.model.Resource;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class ResourceGetStepDefinitions {
  private AutomationApi automationApi;

  public ResourceGetStepDefinitions(AutomationApi automationApi) {
    this.automationApi = automationApi;
  }

  @When("^the GET REST endpoint has been called$")
  public void the_GET_REST_endpoint_has_been_called() throws Throwable {
    final String url = String.format("http://localhost:%d%s/%d", RunCukesTest.RULE.getLocalPort(),
        automationApi.endpoint, automationApi.id);
    final Client client = new JerseyClientBuilder().build();
    final Response response = client.target(url).request().get();

    automationApi.statusCode = response.getStatus();

    if (response.getStatus() == Response.Status.OK.getStatusCode()) {
      automationApi._resource = response.readEntity(Resource.class);
    } else if (response.getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
      automationApi._error = response.readEntity(AppError.class);
    }
  }

  @Then("^a resource is returned with an id = (\\d+)$")
  public void a_resource_is_returned_with_an_id(final Integer id) throws Throwable {
    assertEquals(id, automationApi._resource.getId());
  }

  @Then("^a name = \"([^\"]*)\"$")
  public void a_name(final String name) throws Throwable {
    assertEquals(name, automationApi._resource.getName());
  }

  @Then("^a description = \"([^\"]*)\"$")
  public void a_description(final String description) throws Throwable {
    assertEquals(description, automationApi._resource.getDescription());
  }
}
