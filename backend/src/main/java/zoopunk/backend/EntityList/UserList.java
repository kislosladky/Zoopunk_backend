package zoopunk.backend.EntityList;

import zoopunk.backend.Entity.User;

import java.util.List;

public class UserList {
    private List<User> userList;

    public UserList() {
        this.userList = null;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
