package montp.data.dao;

import montp.data.entity.PersonEntity;
import montp.data.entity.ResourceEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ResourceDAO extends GenericDAO<ResourceEntity> {
    public ResourceDAO() { super(ResourceEntity.class); }

    public List<ResourceEntity> findByPerson(PersonEntity person) {
        return this.em.createQuery(makeQLString("p", "WHERE p.person = :person"))
                .setParameter("person", person)
                .getResultList();
    }
}
