package com.hilton.soa.steps;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.JerseyClientBuilder;
import com.hilton.soa.RunCukesTest;
import cucumber.api.java.en.When;

public class ResourceDeleteStepDefinitions {
  private AutomationApi automationApi;

  public ResourceDeleteStepDefinitions(AutomationApi automationApi) {
    this.automationApi = automationApi;
  }

  @When("^the DELETE REST endpoint has been called$")
  public void the_DELETE_REST_endpoint_has_been_called() throws Throwable {
    final String url = String.format("http://localhost:%d%s/%d", RunCukesTest.RULE.getLocalPort(),
        automationApi.endpoint, automationApi.id);
    final Client client = new JerseyClientBuilder().build();
    final Response response = client.target(url).request().delete();

    automationApi.statusCode = response.getStatus();
  }

}
