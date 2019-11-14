package montp.services;

import montp.data.dao.ResourceTypeDAO;
import montp.data.entity.ResourceTypeEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResourceTypeService extends GenericService<ResourceTypeEntity, ResourceTypeDAO> {}
