package montp.data.dao;

import montp.data.entity.BookingEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookingDAO extends GenericDAO<BookingEntity> {
    public BookingDAO() { super(BookingEntity.class); }
}
