package montp.web.converters;

import montp.data.dao.UserDAO;
import montp.data.entity.security.UserEntity;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = UserEntity.class)
public class UserConverter extends GenericConverter<UserEntity>{

    public UserConverter() {
        super(Tools.lookupBean(UserDAO.class));
    }
    
}
