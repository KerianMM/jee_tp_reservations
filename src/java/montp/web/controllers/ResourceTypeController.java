package montp.web.controllers;

import montp.services.ResourceTypeService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named("controller.resource.type")
public class ResourceTypeController implements Serializable {

    @Inject private ResourceTypeService service;

    public String list() {
        return "list";
    }
}
