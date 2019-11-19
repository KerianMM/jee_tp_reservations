package montp.services;

import montp.data.dao.PersonDAO;
import montp.data.entity.PersonEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonService extends GenericService<PersonEntity, PersonDAO> {}
