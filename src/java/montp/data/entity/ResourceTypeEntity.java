package montp.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "resource_type")
public class ResourceTypeEntity extends GenericEntity {
    @Column(nullable = false) protected String title;
    @Column(nullable = false) protected Boolean shareable = false;
    @Column(nullable = false) protected Boolean hasCapacity = false;

    @OneToMany(mappedBy = "type")
    protected List<ResourceEntity> resources;

    public ResourceTypeEntity() {}
    public ResourceTypeEntity(String title, Boolean shareable, Boolean hasCapacity) {
        this.title = title;
        this.shareable = shareable;
        this.hasCapacity = hasCapacity;
    }

    //region GETTERS / SETTERS
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

    public Boolean getHasCapacity() {
        return hasCapacity;
    }

    public void setHasCapacity(Boolean hasCapacity) {
        this.hasCapacity = hasCapacity;
    }

    public List<ResourceEntity> getResources() {
        return resources;
    }

    public void setResources(List<ResourceEntity> resources) {
        this.resources = resources;
    }
    //endregion

    @Override
    public String toString() { return title; }
}