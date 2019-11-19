package montp.data.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SECURITY_GROUP")
public class GroupEntity {

    @Id
    @Column(columnDefinition = "TEXT")
    protected String groupName;

    public GroupEntity() {}
    public GroupEntity(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
