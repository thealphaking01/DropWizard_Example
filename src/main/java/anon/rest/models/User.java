package anon.rest.models;

import lombok.Data;

import java.util.List;

/**
 * Created by abdur.rahman on 31/05/17.
 */

@Data
public class User {

    public static int currentUid = 0;

    private int uid;
    private String name;
    private List<Integer> topics;

    public User(String name){
        this.name = name;
        this.uid = getCurrentUid() + 1;
        User.currentUid = this.uid;
    }

    public static int getCurrentUid() {
        return currentUid;
    }

    public static void setCurrentUid(int currentUid) {
        User.currentUid = currentUid;
    }

}
