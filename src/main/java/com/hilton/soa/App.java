package com.hilton.soa;

import org.skife.jdbi.v2.DBI;
import com.hilton.soa.api.Api;
import com.hilton.soa.config.AppConfig;
import com.hilton.soa.exception.NotFoundExceptionMapper;
import com.hilton.soa.repository.ResourceRepository;
import com.hilton.soa.service.impl.ResourceServiceImpl;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfig> {
  public static void main(String[] args) throws Exception {
    new App().run(args);
  }

  @Override
  public void run(AppConfig appConfig, Environment environment) throws Exception {
    final DBIFactory factory = new DBIFactory();
    final DBI jdbi = factory.build(environment, appConfig.getDataSourceFactory(), "h2");
    final ResourceRepository dao = jdbi.onDemand(ResourceRepository.class);

    environment.jersey().register(NotFoundExceptionMapper.class);
    environment.jersey().register(new Api(new ResourceServiceImpl(dao)));
  }
}
