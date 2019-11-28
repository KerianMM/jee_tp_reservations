package montp.services;

import montp.data.dao.BookingDAO;
import montp.data.entity.BookingEntity;
import montp.data.entity.PersonEntity;
import montp.data.entity.ResourceEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BookingService extends GenericService<BookingEntity, BookingDAO> {
    public List<BookingEntity> getByPerson(PersonEntity person) {
        return dao.findByPerson(person);
    }
}
