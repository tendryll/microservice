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

  @Override()
  public long insert(String name, String description) {
    return resourceRepository.insert(name, description);
  }

  @Override()
  public void delete(Integer id) {
    if (resourceRepository.findById(id) == null) {
      throw new NotFoundException("Resource not found.");
    }

    resourceRepository.delete(id);
  }

  @Override()
  public void update(Integer id, String name, String description) {
    if (resourceRepository.findById(id) == null) {
      throw new NotFoundException("Resource not found.");
    }

    resourceRepository.update(id, name, description);
  }

  @Override()
  public Resource getById(Integer id) {
    final Resource resource = resourceRepository.findById(id);

    if (resource == null) {
      throw new NotFoundException("Resource not found.");
    }

    return resource;
  }
}
