package montp.data.entity.security;

import montp.data.model.GroupModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="SECURITY_GROUP")
public class GroupEntity extends GroupModel {

    @Id
    @Column(columnDefinition = "TEXT")
    protected String groupName;

    public GroupEntity() { super(); }
    public GroupEntity(String groupName) {
        super(groupName);
    }
}
