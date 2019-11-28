package montp.web.controllers.booking;

import montp.data.entity.BookingEntity;
import montp.data.entity.ResourceEntity;
import montp.data.entity.security.UserEntity;
import montp.services.BookingService;
import montp.services.ResourceService;
import montp.web.controllers.base.CUDController;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ViewScoped
@Named("controller.booking.user.create")
public class BookingUserCController extends CUDController<BookingEntity, BookingService> {

    @Inject protected UserEntity user;

    @Inject private ResourceService resourceService;

    private List<ResourceEntity> resourceEntities;
    private BookingEntity bookingEntity;

    @Override
    public void init() {
        super.init();
        resourceEntities = resourceService.getByOwnerNot(user.getPerson());
    }

    @Override
    public void create() {
        entity = new BookingEntity();
        entity.setPerson(user.getPerson());
    }

    //region GETTERS / SETTERS
    public List<ResourceEntity> getResourceEntities() {
        return resourceEntities;
    }

    public void setResourceEntities(List<ResourceEntity> resourceEntities) {
        this.resourceEntities = resourceEntities;
    }

    public BookingEntity getBookingEntity() {
        return bookingEntity;
    }

    public void setBookingEntity(BookingEntity bookingEntity) {
        this.bookingEntity = bookingEntity;
    }
    //endregion

    public void createFromResource(ResourceEntity resourceEntity) {
        create();
        bookingEntity.setResource(resourceEntity);
    }
}
