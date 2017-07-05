package anon.rest.models;

import javafx.util.Pair;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by abdur.rahman on 02/06/17.
 */
@Data
public class TopicList {

    private List<Topic> topicList;
    private List<Pair<Topic, List<User>>> topicUserList;

    public TopicList(){
        this.topicList = new ArrayList<>();
        this.topicUserList = new ArrayList<>();
    }

    public void addTopic(Topic topic){
        this.topicList.add(topic);
    }

    public void addTopic(String name, String category){
        this.topicList.add(new Topic(name, category));
    }

    public void addMapping(Topic topic, User user){
        boolean val = false;
        for(Pair<Topic, List<User>> ele : topicUserList){
            if(ele.getKey() == topic){
                ele.getValue().add(user);
                val = true;
            }
        }
        if(!val){
            List<User> userList = new ArrayList<User>();
            userList.add(user);
            Pair<Topic, List<User>> pair = new Pair<Topic, List<User>>(topic, userList);
            this.topicUserList.add(pair);
        }
    }

    public Topic findTopic(int tid){
        for(Topic topic: topicList){
            if(topic.getTid() == tid)
                return topic;
        }
        return null;
    }

    public List<User> getFollowers(int tid){
        for(Pair<Topic, List<User>> ele : topicUserList){
            if(ele.getKey().getTid() == tid){
                return ele.getValue();
            }
        }
        return null;
    }

}
