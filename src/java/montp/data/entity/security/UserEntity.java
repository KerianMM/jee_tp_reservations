package montp.data.entity.security;

import montp.data.entity.GenericEntity;
import montp.data.entity.PersonEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SECURITY_USER")
public class UserEntity extends GenericEntity {

    @Column(nullable = false, unique = true, length = 50)
    protected String userName;
    @Column(columnDefinition = "TEXT")
    protected String password;
    @Column(columnDefinition = "TEXT")
    protected String oldPassword;
    @Column(nullable = false)
    protected Boolean active = true;

    @OneToOne
    protected PersonEntity person;

    @ManyToMany
    @JoinTable(name = "SECURITY_USER_GROUP",
            joinColumns = @JoinColumn(name = "username",
                    referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(name = "groupname",
                    referencedColumnName = "groupname"))
    protected List<GroupEntity> groups;

    public UserEntity() {}
    public UserEntity(String userName, String password, PersonEntity person) {
        this.userName = userName;
        this.password = password;
        this.person = person;
    }
    public UserEntity(String userName, String password, PersonEntity person, Boolean active) {
        this.userName = userName;
        this.password = password;
        this.person = person;
        this.active = active;
    }

    //region GETTERS / SETTERS
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupEntity> groups) {
        this.groups = groups;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
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
        return userName;
    }
}
