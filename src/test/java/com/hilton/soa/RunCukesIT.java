package com.hilton.soa;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import com.hilton.soa.config.AppConfig;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
  features = {"classpath:features/resource.get.feature"},
  glue = {"com.hilton.soa.steps"})
public class RunCukesIT {
  @ClassRule
  public static final DropwizardAppRule<AppConfig> RULE = new DropwizardAppRule<>(
      App.class, ResourceHelpers.resourceFilePath("app.yml"));
}
