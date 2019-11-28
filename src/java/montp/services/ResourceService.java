package montp.services;

import montp.data.dao.ResourceDAO;
import montp.data.entity.PersonEntity;
import montp.data.entity.ResourceEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ResourceService extends GenericService<ResourceEntity, ResourceDAO> {
    public List<ResourceEntity> getByPerson(PersonEntity person) {
        return dao.findByPerson(person);
    }
    public List<ResourceEntity> getByOwnerNot(PersonEntity person) {
        return dao.findByOwnerNot(person);
    }
}
