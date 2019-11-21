package montp.web.controllers.resource;

import montp.data.entity.ResourceEntity;
import montp.data.entity.ResourceTypeEntity;
import montp.data.entity.security.UserEntity;
import montp.services.ResourceService;
import montp.services.ResourceTypeService;
import montp.web.controllers.base.CRUDController;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ViewScoped
@Named("controller.resource.user.crud")
public class ResourceUserCRUDController extends CRUDController<ResourceEntity, ResourceService> {

    @Inject protected UserEntity user;
    @Inject protected ResourceTypeService typeService;

    private List<ResourceTypeEntity> types;

    public void create(){
        entity = new ResourceEntity();
        entity.setPerson(user.getPerson());
    }

    @Override
    public void init() {
        if (user != null) {
            entities = service.getByPerson(user.getPerson());
            types = typeService.getAll();
        }

        create();
    }

    //region GETTERS / SETTERS
    public List<ResourceTypeEntity> getTypes() {
        return types;
    }

    public void setTypes(List<ResourceTypeEntity> types) {
        this.types = types;
    }
    //endregion
}
