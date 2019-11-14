package montp.data.model;


import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public class UserModel extends GenericModel {

    private String userName;
    private String password;
    private String oldPassword;

    private List<GroupModel> groups;

    public UserModel() {}
    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //region GETTERS / SETTERS
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GroupModel> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupModel> groups) {
        this.groups = groups;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    //endregion

    @Override
    public String toString() {
        return userName;
    }
}
