package montp.services;

import montp.data.dao.BookingDAO;
import montp.data.entity.BookingEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookingService extends GenericService<BookingEntity, BookingDAO> {}
