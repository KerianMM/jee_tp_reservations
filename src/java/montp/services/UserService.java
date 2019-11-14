package montp.services;

import montp.data.dao.UserDAO;
import montp.data.entity.security.GroupEntity;
import montp.data.entity.security.UserEntity;
import montp.data.model.GroupModel;
import montp.tools.Tools;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class UserService extends GenericService<UserEntity, UserDAO> {
    //region GETTERS
    public UserEntity getOneByUsername(String username) {
        return dao.findOneByUsername(username.toLowerCase().trim());
    }

    public GroupEntity getGroup(String groupname) { return dao.getGroup(groupname.toUpperCase().trim()); }
    //endregion

    //region VERIFICATIONS
    public boolean isActive(UserEntity user) {
        UserEntity u = get(user);
        return (u != null) && u.getPassword() != null;
    }

    public boolean checkIfExists(String username) {
        return getOneByUsername(username) != null;
    }
    //endregion

    //region TRANSACTIONS
    @Transactional
    public void disable(UserEntity user) {
        String password = user.getPassword();
        user.setOldPassword(password);
        user.setPassword(null);
        super.update(user);
    }

    @Transactional
    public void enable(UserEntity user) {
        String password = user.getOldPassword();
        user.setPassword(password);
        user.setOldPassword(null);
        super.update(user);
    }

    @Transactional
    public void insert(UserEntity user) {
        if (user.getGroups() == null) {
            List<GroupModel> groupes = new LinkedList<>();
            groupes.add(getGroup("USER"));
            user.setGroups(groupes);
        }
        user.setPassword(Tools.digestSHA256Hex(user.getPassword().trim()));
        user.setUserName(user.getUserName().toLowerCase().trim());
        super.insert(user);
    }
    //endregion
}
