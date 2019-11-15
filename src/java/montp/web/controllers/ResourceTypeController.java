package montp.web.controllers;

import montp.data.entity.ResourceTypeEntity;
import montp.locale.Messages;
import montp.services.ResourceTypeService;
import montp.web.FacesTools;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named("controller.resource.type")
public class ResourceTypeController implements Serializable {

    @Inject private Messages messages;
    @Inject private ResourceTypeService service;

    @Named @Produces private List<ResourceTypeEntity> resourceTypeEntities;
    @Named @Produces private ResourceTypeEntity resourceTypeEntity;

    @PostConstruct public void init() {
        resourceTypeEntities = service.getAll();
    }

    //region GETTERS / SETTERS
    public List<ResourceTypeEntity> getResourceTypeEntities() {
        return resourceTypeEntities;
    }

    public void setResourceTypeEntities(List<ResourceTypeEntity> resourceTypeEntities) {
        this.resourceTypeEntities = resourceTypeEntities;
    }

    public ResourceTypeEntity getResourceTypeEntity() {
        return resourceTypeEntity;
    }

    public void setResourceTypeEntity(ResourceTypeEntity resourceTypeEntity) {
        this.resourceTypeEntity = resourceTypeEntity;
    }
    //endregion

    //region ACTIONS
    public void create(){
        resourceTypeEntity = new ResourceTypeEntity();
    }

    public void save(){
        boolean created = service.save(resourceTypeEntity);

        FacesTools.addMessage(
            FacesMessage.SEVERITY_INFO,
            (created ?messages.get("app.added") :messages.get("app.updated"))
        );

        if (created) { init(); }
    }

    public boolean canDelete(ResourceTypeEntity entity) {
        return service.canDelete(entity);
    }

    public void delete(ResourceTypeEntity entity) {
        service.delete(entity);

        if (service.canDelete(entity)) {
            FacesTools.addMessage(
                    FacesMessage.SEVERITY_ERROR,
                    messages.get("app.delete.error")
            );
        } else {
            FacesTools.addMessage(
                    FacesMessage.SEVERITY_INFO,
                    messages.get("app.deleted")
            );

            init();
        }
    }
    //endregion
}
