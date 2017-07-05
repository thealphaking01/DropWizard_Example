package anon.rest.services;

import anon.rest.models.Topic;
import anon.rest.models.TopicList;
import anon.rest.models.User;
import anon.rest.models.UserList;
import javafx.util.Pair;

import java.util.List;

import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by abdur.rahman on 31/05/17.
 */

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)

public class ServiceRESTController {
    private final Validator validator;
    private UserList userList;
    private TopicList topicList;

    public ServiceRESTController(Validator validator) {
        this.validator = validator;
        this.userList = new UserList();
        this.topicList = new TopicList();
    }

    @GET
    @Path("/user")
    public List<User> getUsers() {
        return this.userList.getUserList();
    }

    @GET
    @Path("/topic")
    public List<Topic> getTopics() {
        return this.topicList.getTopicList();
    }

    @GET
    @Path("/topic/followers")
    public List<Pair<Topic, List<User>>> getTopicUserList() {
        return this.topicList.getTopicUserList();
    }

    @POST
    @Path("/user/{name}")
    public List addUser(@PathParam("name") String name){
        this.userList.addUser(name);
        return this.userList.getUserList();
    }

    @POST
    @Path("/topic/{name}/{category}")
    public List<Topic> addTopic(@PathParam("name") String name, @PathParam("category") String category){
        this.topicList.addTopic(name, category);
        return this.topicList.getTopicList();
    }

    @POST
    @Path("/follow/{uid}/{tid}")
    public Response addMapping(@PathParam("uid") int uid, @PathParam("tid") int tid){
        User user = this.userList.findUser(uid);
        Topic topic = this.topicList.findTopic(tid);
        if(user != null && topic != null){
            this.topicList.addMapping(topic, user);
            return Response.ok().build();
        }
        else{
            return null;
        }
    }

    @GET
    @Path("/topic/{tid}")
    public Topic findTopic(@PathParam("tid") int tid){
        return this.topicList.findTopic(tid);
    }

    @GET
    @Path("/follow/{tid}")
    public List<User> listFollowers(@PathParam("tid") int tid){
        return this.topicList.getFollowers(tid);
    }
}
