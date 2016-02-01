package com.hilton.soa.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import com.hilton.soa.model.AppError;

public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

  @Override
  public Response toResponse(NotFoundException ex) {
    final AppError appError = new AppError(ex.getMessage());

    return Response.status(Response.Status.NOT_FOUND).entity(appError).build();
  }
}
