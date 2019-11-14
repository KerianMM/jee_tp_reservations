package montp.web.controllers;

import montp.data.entity.security.UserEntity;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named("index")
public class IndexView implements Serializable {

    @Inject
    private UserEntity user;

    @PostConstruct
    public void init() {
    }

}
