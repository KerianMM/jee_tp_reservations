package montp.web.converters;

import montp.data.dao.GenericDAO;
import montp.data.model.GenericModel;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class GenericConverter<T extends GenericModel> implements Converter {

    protected GenericDAO<T> dao;

    public GenericConverter(GenericDAO<T> dao) {
        this.dao = dao;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String id) {
        return dao.find(Integer.parseInt(id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) return null;
        T o = (T) value;
        if (o.getId() == null) return null;
        return ((T) value).getId().toString();
    }

}
