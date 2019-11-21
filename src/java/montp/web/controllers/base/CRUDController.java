package montp.web.controllers.base;

import montp.data.entity.GenericEntity;
import montp.services.GenericService;
import montp.web.FacesTools;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

public abstract class CRUDController<T extends GenericEntity, Service extends GenericService> extends Controller {

    @Inject protected Service service;

    @Named
    @Produces
    protected List<T> entities;
    @Named @Produces protected T entity;

    @PostConstruct
    public void onPostConstruct() {
        init();
    }
    public void init() {
        entities = service.getAll();
    }

    //region GETTERS / SETTERS
    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
    //endregion

    //region ACTIONS
    public abstract void create();

    public void save(){
        boolean created = service.save(entity);

        FacesTools.addMessage(
                FacesMessage.SEVERITY_INFO,
                (created ?messages.get("app.added") :messages.get("app.updated"))
        );

        if (created) { init(); }
    }

    public boolean canDelete(T entity) {
        return service.canDelete(entity);
    }

    public void delete(T entity) {
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
