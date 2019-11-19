package montp.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class BookingEntity extends GenericEntity {

    @Column(nullable = false) protected Date dateStart;
    @Column(nullable = false) protected Date dateEnd;
    @Column(nullable = false) protected Integer capacity;
    @Column(nullable = false) protected Boolean active = true;

    @ManyToOne protected ResourceEntity resource;
    @ManyToOne protected PersonEntity person;

    public BookingEntity() {}
    public BookingEntity(ResourceEntity resource, PersonEntity person, Date dateStart, Date dateEnd, Integer capacity, Boolean active) {
        this.resource = resource;
        this.person = person;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.capacity = capacity;
        this.active = active;
    }

    //region GETTERS / SETTERS
    public ResourceEntity getResource() {
        return resource;
    }

    public void setResource(ResourceEntity resource) {
        this.resource = resource;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%s pour %s", resource.type, person);
    }
}
