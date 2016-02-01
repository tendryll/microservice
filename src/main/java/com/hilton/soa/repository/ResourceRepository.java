package com.hilton.soa.repository;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import com.hilton.soa.model.Resource;
import com.hilton.soa.repository.mapper.ResourceMapper;

@RegisterMapper(value = ResourceMapper.class)
public interface ResourceRepository {
  @SqlUpdate("insert into resources (id, name, description) values (:id, :name, :desc)")
  void insert(@Bind("id") Integer id, @Bind("name") String name, @Bind("desc") String description);

  @SqlQuery("select * from resources where id = :id")
  Resource findById(@Bind("id") Integer id);

  @SqlUpdate("update resources set name = :name, description = :desc where id = :id")
  void update(@Bind("id") Integer id, @Bind("name") String name, @Bind("desc") String description);

  @SqlUpdate("delete from resources where id = :id")
  void delete(@Bind("id") Integer id);
}
