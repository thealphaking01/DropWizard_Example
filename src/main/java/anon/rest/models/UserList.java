package anon.rest.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdur.rahman on 31/05/17.
 */
@Data
public class UserList {

    private List<User> userList;

    public UserList(){
        userList = new ArrayList<User>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(String name){
        User user = new User(name);
        this.userList.add(user);
    }

    public int getSize(){
        return this.userList.size();
    }

    public User findUser(int uid){
        for(User user: userList){
            if(user.getUid() == uid)
                return user;
        }
        return null;
    }
}
