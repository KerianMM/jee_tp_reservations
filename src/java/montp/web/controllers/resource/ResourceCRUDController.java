package montp.web.controllers.resource;

import montp.data.entity.ResourceEntity;
import montp.services.ResourceService;
import montp.web.controllers.base.CRUDController;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named("controller.resource.crud")
public class ResourceCRUDController extends CRUDController<ResourceEntity, ResourceService> {
    public void create(){ entity = new ResourceEntity(); }
}
