package montp.web.converters;

import montp.data.dao.BookingDAO;
import montp.data.entity.BookingEntity;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = BookingEntity.class)
public class BookingConverter extends GenericConverter<BookingEntity>{

    public BookingConverter() {
        super(Tools.lookupBean(BookingDAO.class));
    }
    
}
