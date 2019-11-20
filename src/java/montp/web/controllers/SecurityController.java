package montp.web.controllers;

import montp.web.FacesTools;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named("controller.security")
public class SecurityController implements Serializable {

    public void logout() {
        FacesTools.getRequest().getSession().invalidate();
        FacesTools.redirect("app/index.xhtml");
    }

    public void login() {
        FacesTools.redirect("app/index.xhtml");
    }

    public void securityCheck() {}
}
