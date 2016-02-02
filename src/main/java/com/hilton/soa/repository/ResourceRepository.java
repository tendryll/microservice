package com.hilton.soa.repository;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import com.hilton.soa.model.Resource;
import com.hilton.soa.repository.mapper.ResourceMapper;

@RegisterMapper(value = ResourceMapper.class)
public interface ResourceRepository {
  @SqlUpdate("insert into resources (name, description) values (:name, :desc)")
  @GetGeneratedKeys()
  long insert(@Bind("name") final String name, @Bind("desc") final String description);

  @SqlQuery("select * from resources where id = :id")
  Resource findById(@Bind("id") final Integer id);

  @SqlUpdate("update resources set name = :name, description = :desc where id = :id")
  void update(@Bind("id") final Integer id, @Bind("name") final String name, @Bind("desc") final String description);

  @SqlUpdate("delete from resources where id = :id")
  void delete(@Bind("id") final Integer id);
}
