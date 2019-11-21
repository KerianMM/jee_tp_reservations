package montp.web.converters;

import montp.data.dao.ResourceTypeDAO;
import montp.data.entity.ResourceTypeEntity;
import montp.data.entity.security.UserEntity;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = ResourceTypeEntity.class)
public class ResourceTypeConverter extends GenericConverter<ResourceTypeEntity>{

    public ResourceTypeConverter() {
        super(Tools.lookupBean(ResourceTypeDAO.class));
    }
    
}
