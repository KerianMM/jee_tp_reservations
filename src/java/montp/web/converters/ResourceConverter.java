package montp.web.converters;

import montp.data.dao.ResourceDAO;
import montp.data.entity.ResourceEntity;
import montp.data.entity.security.UserEntity;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = ResourceEntity.class)
public class ResourceConverter extends GenericConverter<ResourceEntity>{

    public ResourceConverter() {
        super(Tools.lookupBean(ResourceDAO.class));
    }
    
}
