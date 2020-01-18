package io.javabrains.springbootstarter.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
   private TopicService Topicservice;

    @RequestMapping("/topics")
    public List<Topic>  getAllTopics(){

        return Topicservice.getAllTopics();
//        List<Course> list = new ArrayList<>();
//        list.add(new Course("Spring","Spring Framework" , "Spring Framework Description"));
//        list.add(new Course("Java","Java Core" , "Java Core Description"));
//        list.add(new Course("Java Script","JavaScript" , "JavaScript Description"));
//        return  list ;
    }

    @GetMapping("/topic/{id}")
    public Optional<Topic> getTopicById(@PathVariable String id){
        return Topicservice.getTopic(id);
    }



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
