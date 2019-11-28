package montp.data.dao;

import montp.data.entity.PersonEntity;
import montp.data.entity.ResourceEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ResourceDAO extends GenericDAO<ResourceEntity> {
    public ResourceDAO() { super(ResourceEntity.class); }

    //region FINDERS
    public List<ResourceEntity> findByPerson(PersonEntity person) {
        return this.em.createQuery(makeQLString("p", "WHERE p.person = :person"))
                .setParameter("person", person)
                .getResultList();
    }

    public List<ResourceEntity> findByOwnerNot(PersonEntity person) {
        String query = makeQLString("r", "WHERE r.person != :person");
        return this.em.createQuery(query)
                .setParameter("person", person)
                .getResultList();
    }
    //endregion

    @Override
    public boolean canDelete(ResourceEntity instance) {
        return super.canDelete(instance) && instance.getBookings().isEmpty();
    }
}
