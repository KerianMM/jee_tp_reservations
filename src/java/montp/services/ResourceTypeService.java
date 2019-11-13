package montp.services;

import montp.data.dao.ResourceTypeDAO;
import montp.data.model.ResourceTypeEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ResourceTypeService extends GenericService<ResourceTypeEntity, ResourceTypeDAO> {
    public List<ResourceTypeEntity> getAll() {
        return dao.findAll();
    }
}
