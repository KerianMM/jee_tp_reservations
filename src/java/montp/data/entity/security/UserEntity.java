package montp.data.entity.security;

import montp.data.model.UserModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SECURITY_USER")
public class UserEntity extends UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
    @Column(nullable = false, unique = true, length = 50)
    protected String userName;
    @Column(columnDefinition = "TEXT")
    protected String password;
    @Column(columnDefinition = "TEXT")
    protected String oldPassword;

    @ManyToMany
    @JoinTable(name = "SECURITY_USER_GROUP",
            joinColumns = @JoinColumn(name = "username",
                    referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(name = "groupname",
                    referencedColumnName = "groupname"))
    protected List<GroupEntity> groups;

    public UserEntity() { super(); }
    public UserEntity(String userName, String password) { super(userName, password); }
}
