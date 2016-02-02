package com.hilton.soa.steps;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.JerseyClientBuilder;
import com.hilton.soa.RunCukesTest;
import com.hilton.soa.model.AppError;
import com.hilton.soa.model.Resource;
import cucumber.api.java.en.When;

public class ResourcePutStepDefinitions {
  private AutomationApi automationApi;

  public ResourcePutStepDefinitions(AutomationApi automationApi) {
    this.automationApi = automationApi;
  }

  @When("^the PUT REST endpoint has been called$")
  public void the_PUT_REST_endpoint_has_been_called() throws Throwable {
    final Resource resource = new Resource();
    resource.setName(automationApi.name);
    resource.setDescription(automationApi.description);

    final String url = String.format("http://localhost:%d%s/%d", RunCukesTest.RULE.getLocalPort(),
        automationApi.endpoint, automationApi.id);
    final Client client = new JerseyClientBuilder().build();
    final Response response = client.target(url).request().put(Entity.entity(resource, MediaType
        .APPLICATION_JSON_TYPE));

    automationApi.statusCode = response.getStatus();

//    if (response.getStatus() == Response.Status.OK.getStatusCode()) {
//      automationApi._resource = response.readEntity(Resource.class);
//    } else if (response.getStatus() == Response.Status.NO_CONTENT.getStatusCode()) {
//      automationApi._resource = response.readEntity(Resource.class);
//    } else if (response.getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
//      automationApi._error = response.readEntity(AppError.class);
//    }
  }
}
