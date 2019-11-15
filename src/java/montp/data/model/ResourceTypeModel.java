package montp.data.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ResourceTypeModel extends GenericModel {
    protected String title;
    protected Boolean shareable = false;

    public ResourceTypeModel() {}
    public ResourceTypeModel(String title, Boolean shareable) {
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

    @Override
    public String toString() { return title; }
}
