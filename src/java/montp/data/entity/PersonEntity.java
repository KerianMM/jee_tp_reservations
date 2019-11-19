package montp.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class PersonEntity extends GenericEntity {
    
    @Column(nullable = false) protected String firstName;
    @Column(nullable = false) protected String lastName;
    @Column(nullable = false) protected String email;

    public PersonEntity() {}
    public PersonEntity(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //region GETTERS / SETTERS
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName.toUpperCase());
    }
}
