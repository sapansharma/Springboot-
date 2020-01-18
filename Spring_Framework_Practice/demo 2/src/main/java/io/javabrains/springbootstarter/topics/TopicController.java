package io.javabrains.springbootstarter.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
   private TopicService Topicservice;

    @RequestMapping("/topics")
    public List<Topic>  getAllTopics(){

        return Topicservice.getAllTopics();
//        List<Topic> list = new ArrayList<>();
//        list.add(new Topic("Spring","Spring Framework" , "Spring Framework Description"));
//        list.add(new Topic("Java","Java Core" , "Java Core Description"));
//        list.add(new Topic("Java Script","JavaScript" , "JavaScript Description"));
//        return  list ;
    }

    @GetMapping("/topic/{id}")
    public Topic getTopicById(@PathVariable String id){
        return Topicservice.getTopic(id);
    }



// todo:  Need to discuss with Shridhar or Amith why it's giving exception -
//    com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `io.javabrains.springbootstarter.topics.Topic` (no Creators, like default construct, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
    @RequestMapping(method=RequestMethod.POST , value = "/topics")
    public void createTopic(@RequestBody Topic topic){
        Topicservice.addTopic(topic);
    }


    //todo: Same problem as above function.
    @RequestMapping(method=RequestMethod.PUT , value = "/topic/{id}")
    public void updateTopic(@RequestBody Topic topic , @PathVariable String id ){
        Topicservice.updateTopic(topic ,id);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        Topicservice.deleteTopic(id);

    }

}
