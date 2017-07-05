package anon.rest.models;

import lombok.Data;

/**
 * Created by abdur.rahman on 31/05/17.
 */
@Data
public class Topic {

    private static int currentTid = 0;
    private int tid;
    private String name;

    private int currentFollowers;
    private String topicCategory;

    public static int getCurrentTid() {

        return currentTid;
    }

    public static void setCurrentTid(int currentTid) {
        Topic.currentTid = currentTid;
    }

    public Topic(String name, String topicCategory){
        this.name = name;
        this.topicCategory = topicCategory;
        this.currentFollowers = 0;
        this.tid = getCurrentTid() + 1;
        this.setCurrentTid(this.tid);
    }
}
