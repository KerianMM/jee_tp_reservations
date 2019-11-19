package montp.services;

import montp.data.dao.ResourceDAO;
import montp.data.entity.ResourceEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResourceService extends GenericService<ResourceEntity, ResourceDAO> {}
