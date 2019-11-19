package montp.services;

import montp.data.dao.GenericDAO;
import montp.data.entity.GenericEntity;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

public abstract class GenericService<T extends GenericEntity, DAO extends GenericDAO<T>> {

    @Inject
    protected DAO dao;

    //region GETTERS
    public T get(long id) {     return dao.find(id); }
    public T get(T entity) {    return dao.find(entity.getId()); }
    public List<T> getAll() {   return dao.findAll(); }
    public List<T> getPaged() { return dao.findPaged(1, 10); }
    public List<T> getPaged(Integer page) { return dao.findPaged(page, 10); }
    public List<T> getPaged(Integer page, Integer perPage) { return dao.findPaged(page, perPage); }
    //endregion

    //region TRANSACTIONS
    @Transactional
    public boolean save(T instance) {
        if (instance.getId() == null) {
            insert(instance);
            return true;
        }
        update(instance);
        return false;
    }

    @Transactional
    public void insert(T instance) { dao.insert(instance); }

    @Transactional
    public void update(T instance) { dao.update(instance); }

    @Transactional
    public Boolean delete(T instance) {
        if (canDelete(instance)) {
            dao.delete(instance);

            return !canDelete(instance);
        }

        return false;
    }
    //endregion

    public boolean canDelete(T instance) { return dao.canDelete(instance); }

    public Integer count() { return dao.count(); }

    public boolean isEmpty() { return dao.isEmpty(); }
}
