package montp.web.controllers.base;

import montp.locale.Messages;

import javax.inject.Inject;
import java.io.Serializable;

public abstract class Controller implements Serializable {
    @Inject protected Messages messages;
}
