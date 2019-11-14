package montp.data.dao;

import montp.data.entity.security.GroupEntity;
import montp.data.entity.security.UserEntity;
import montp.tools.Tools;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserDAO extends GenericDAO<UserEntity> {

    public UserDAO() {
        super(UserEntity.class);
    }

    public UserEntity findOneByUsername(String username) {
        return (UserEntity) em.createQuery(makeQLString("e", "WHERE e.userName=:username"))
                .setParameter("username", username)
                .getSingleResult();
    }

    public GroupEntity getGroup(String groupname) {
        return em.find(GroupEntity.class, groupname);
    }

    @Transactional
    public void update(UserEntity user) {
        UserEntity u = em.find(UserEntity.class, user.getId());
        em.createNativeQuery("DELETE FROM SECURITY_USER_GROUP WHERE username=?1")
                .setParameter(1, u.getUserName())
                .executeUpdate();
        u.setUserName(user.getUserName().toLowerCase().trim());
        if ((user.getPassword() != null)
                && (!user.getPassword().trim().isEmpty())) {
            u.setPassword(Tools.digestSHA256Hex(user.getPassword().trim()));
        }
        super.update(u);
        em.createNativeQuery("INSERT INTO SECURITY_USER_GROUP(username,groupname) VALUES(?1,?2)")
                .setParameter(1, u.getUserName())
                .setParameter(2, "USER")
                .executeUpdate();
    }
}
