package montp.data.dao;

import montp.data.entity.GenericEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public abstract class GenericDAO<T extends GenericEntity> {

    @PersistenceContext
    protected EntityManager em;
    protected Class<T> instanceClass;

    public GenericDAO() {}
    public GenericDAO(Class<T> instanceClass) {
        this.instanceClass = instanceClass;
    }

    //region FINDERS
    public T find(long id) {
        return em.find(instanceClass, id);
    }

    public List<T> findAll() {
        return this.em.createQuery(makeQLString()).getResultList();
    }

    public List<T> findPaged(Integer page, Integer perPage) {
        return this.em.createQuery(makeQLString())
            .setMaxResults(perPage)
            .setFirstResult((page > 1) ?perPage * (page-1) :0)
            .getResultList();
    }
    //endregion

    //region QLMAKERS
    protected String makeQLString() {
        return makeQLString("e");
    }
    protected String makeQLString(String alias) {
        return String.format(
            "SELECT %2$s FROM %s %2$s",
            instanceClass.getSimpleName(),
            alias
        );
    }
    protected String makeQLString(String alias, String query) {
        return String.format("%s %s",
            makeQLString(alias),
            query
        );
    }
    //endregion

    //region TRANSACTIONS
    @Transactional
    public void insert(T instance) {
        em.persist(instance);
        em.flush();
    }

    @Transactional
    public void update(T instance) {
        em.merge(instance);
    }

    @Transactional
    public void delete(T instance) {
        em.remove(em.find(instanceClass, instance.getId()));
    }
    //endregion

    public boolean canDelete(T instance) { return find(instance.getId()) != null; }

    public Integer count() {
        Object singleResult = em
                .createQuery(String.format("SELECT COUNT(e) FROM %s e", instanceClass.getSimpleName()))
                .getSingleResult();

        return (singleResult != null) ?Integer.parseInt(singleResult.toString()) :0;
    }

    public boolean isEmpty() { return count() == 0; }
}
