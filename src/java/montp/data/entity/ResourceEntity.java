package montp.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "resource")
public class ResourceEntity extends GenericEntity {

    @Column(columnDefinition = "INTEGER")
    protected Integer capacity;

    @ManyToOne protected ResourceTypeEntity type;
    @ManyToOne protected PersonEntity person;

    @OneToMany(mappedBy = "resource")
    protected List<BookingEntity> bookings;

    public ResourceEntity() {}
    public ResourceEntity(ResourceTypeEntity type, PersonEntity person, int capacity) {
        this.type = type;
        this.person = person;
        this.capacity = capacity;
    }

    //region GETTERS / SETTERS
    public ResourceTypeEntity getType() {
        return type;
    }

    public void setType(ResourceTypeEntity type) {
        this.type = type;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%s de %s", type, person);
    }
}
