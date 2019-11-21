package montp.web.controllers.resource.type;

import montp.data.entity.ResourceTypeEntity;
import montp.services.ResourceTypeService;
import montp.web.controllers.base.CRUDController;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named("controller.resource.type.crud")
public class ResourceTypeCRUDController extends CRUDController<ResourceTypeEntity, ResourceTypeService> {
    public void create(){
        entity = new ResourceTypeEntity();
    }
}
