package montp.data.dao;

import montp.data.entity.BookingEntity;
import montp.data.entity.PersonEntity;
import montp.data.entity.ResourceEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BookingDAO extends GenericDAO<BookingEntity> {
    public BookingDAO() { super(BookingEntity.class); }

    public List<BookingEntity> findByPerson(PersonEntity person) {
        return this.em.createQuery(makeQLString("b", "WHERE b.person = :person"))
                .setParameter("person", person)
                .getResultList();
    }
}
