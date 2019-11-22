package montp.data.dao;

import montp.data.entity.ResourceTypeEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResourceTypeDAO extends GenericDAO<ResourceTypeEntity> {
    public ResourceTypeDAO() { super(ResourceTypeEntity.class); }

    @Override
    public boolean canDelete(ResourceTypeEntity instance) {
        return instance.getResources().isEmpty() && super.canDelete(instance);
    }
}
