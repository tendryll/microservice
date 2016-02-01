package com.hilton.soa.service.impl;

import javax.ws.rs.NotFoundException;
import com.hilton.soa.model.Resource;
import com.hilton.soa.repository.ResourceRepository;
import com.hilton.soa.service.ResourceService;

public class ResourceServiceImpl implements ResourceService {
  private ResourceRepository resourceRepository;

  public ResourceServiceImpl(ResourceRepository resourceRepository) {
    this.resourceRepository = resourceRepository;
  }

  public void insert(Integer id, String name, String description) {
    resourceRepository.insert(id, name, description);
  }

  public void delete(Integer id) {
    resourceRepository.delete(id);
  }

  public void update(Integer id, String name, String description) {
    resourceRepository.update(id, name, description);
  }

  public Resource getById(Integer id) {
    final Resource resource = resourceRepository.findById(id);

    if (resource == null) {
      throw new NotFoundException("Resource not found.");
    }

    return resource;
  }
}
