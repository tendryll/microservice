package com.hilton.soa.api;

import java.net.URI;
import java.util.concurrent.atomic.AtomicInteger;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import com.hilton.soa.model.Resource;
import com.hilton.soa.service.ResourceService;

@Path("/resource")
public class Api {
  private ResourceService resourceService;
  private AtomicInteger atomic = new AtomicInteger();

  public Api(ResourceService resourceService) {
    this.resourceService = resourceService;
  }

  @POST()
  public Response createWidget(final Resource resource) {
    final Integer id = atomic.incrementAndGet();

    resourceService.insert(id, resource.getName(), resource.getDescription());

    final URI uri = URI.create(String.format("/resource/%d", id));

    return Response.created(uri).build();
  }

  @Path("/{id}")
  @GET()
  @Produces(value = "application/json")
  public Response getResource(@PathParam("id") final Integer id) {
    final Resource resource = resourceService.getById(id);

    return Response.ok(resource).build();
  }

  @Path("/{id}")
  @PUT()
  public Response updateWidget(@PathParam("id") final Integer id, final Resource resource) {
    resourceService.update(id, resource.getName(), resource.getDescription());

    return Response.noContent().build();
  }

  @Path("/{id}")
  @DELETE
  public Response removeWidget(@PathParam("id") final Integer id) {
    resourceService.delete(id);

    return Response.noContent().build();
  }
}
