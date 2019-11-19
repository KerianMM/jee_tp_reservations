package montp.data.dao;

import montp.data.entity.PersonEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonDAO extends GenericDAO<PersonEntity> {
    public PersonDAO() { super(PersonEntity.class); }
}
