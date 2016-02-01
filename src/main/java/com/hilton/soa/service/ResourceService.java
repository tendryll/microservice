package com.hilton.soa.service;

import com.hilton.soa.model.Resource;

public interface ResourceService {
  void insert(Integer id, String name, String description);

  void delete(Integer id);

  void update(Integer id, String name, String
      description);

  Resource getById(Integer id);
}
