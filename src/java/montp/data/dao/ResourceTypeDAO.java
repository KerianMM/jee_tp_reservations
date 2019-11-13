package montp.data.dao;

import montp.data.model.ResourceTypeEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ResourceTypeDAO extends GenericDAO<ResourceTypeEntity> {
    public ResourceTypeDAO() { super(ResourceTypeEntity.class); }

    public List<ResourceTypeEntity> findAll() {
        return this.em.createQuery("SELECT r FROM ResourceTypeEntity r").getResultList();
    }
}
