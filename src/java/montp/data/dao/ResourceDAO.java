package montp.data.dao;

import montp.data.entity.ResourceEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResourceDAO extends GenericDAO<ResourceEntity> {
    public ResourceDAO() { super(ResourceEntity.class); }
}
