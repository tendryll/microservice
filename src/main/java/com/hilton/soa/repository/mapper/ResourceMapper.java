package com.hilton.soa.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.hilton.soa.model.Resource;

public class ResourceMapper implements ResultSetMapper<Resource> {
  public Resource map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
    final Resource resource = new Resource();

    resource.setId(rs.getInt("id"));
    resource.setName(rs.getString("name"));
    resource.setDescription(rs.getString("description"));

    return resource;
  }
}