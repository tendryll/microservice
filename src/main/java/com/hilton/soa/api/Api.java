package com.hilton.soa.api;

import java.net.URI;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import com.hilton.soa.model.Resource;
import com.hilton.soa.service.ResourceService;

@Path("/resource")
public class Api {
  private ResourceService resourceService;

  public Api(ResourceService resourceService) {
    this.resourceService = resourceService;
  }

  @POST()
  @Consumes(value = "application/json")
  @Produces(value = "application/json")
  public Response createWidget(@Valid() @NotNull() final Resource resource) {
    final long id = resourceService.insert(resource.getName(), resource.getDescription());

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
  @Consumes(value = "application/json")
  @Produces(value = "application/json")
  public Response updateWidget(@PathParam("id") final Integer id,
      @Valid() @NotNull() final Resource resource) {
    resourceService.update(id, resource.getName(), resource.getDescription());

    return Response.noContent().build();
  }

  @Path("/{id}")
  @DELETE()
  @Produces(value = "application/json")
  public Response removeWidget(@PathParam("id") final Integer id) {
    resourceService.delete(id);

    return Response.noContent().build();
  }
}
