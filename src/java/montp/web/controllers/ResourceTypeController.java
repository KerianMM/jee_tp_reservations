package montp.web.controllers;

import montp.data.entity.ResourceTypeEntity;
import montp.services.ResourceTypeService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named("controller.resource.type")
public class ResourceTypeController implements Serializable {

    @Inject private ResourceTypeService service;

    public List<ResourceTypeEntity> list() {
        return service.getAll();
    }
}
