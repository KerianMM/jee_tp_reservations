package montp.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "resource_type")
public class ResourceTypeEntity extends GenericEntity {
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Boolean shareable = false;

    public ResourceTypeEntity() {}

    public ResourceTypeEntity(String title, Boolean shareable) {
        this.title = title;
        this.shareable = shareable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getShareable() {
        return shareable;
    }

    public void setShareable(Boolean shareable) {
        this.shareable = shareable;
    }
}
