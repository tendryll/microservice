package com.hilton.soa.steps;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.JerseyClientBuilder;
import com.hilton.soa.RunCukesTest;
import com.hilton.soa.model.AppError;
import com.hilton.soa.model.Resource;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class ResourcePostStepDefinitions {
  private AutomationApi automationApi;

  public ResourcePostStepDefinitions(AutomationApi automationApi) {
    this.automationApi = automationApi;
  }

  @When("^the POST REST endpoint has been called$")
  public void the_POST_REST_endpoint_has_been_called() throws Throwable {
    final Resource resource = new Resource();
    resource.setName(automationApi.name);
    resource.setDescription(automationApi.description);

    final String url = String.format("http://localhost:%d%s", RunCukesTest.RULE.getLocalPort(),
        automationApi.endpoint);
    final Client client = new JerseyClientBuilder().build();
    final Response response = client.target(url).request().post(Entity.entity(resource, MediaType
        .APPLICATION_JSON_TYPE));

    automationApi.statusCode = response.getStatus();

    if (response.getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
      automationApi._error = response.readEntity(AppError.class);
    }
  }

}
