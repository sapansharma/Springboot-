package io.javabrains.springbootstarter.topics;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Spring","Spring Framework" , "Spring Framework Description" ),
            new Topic("Java","Java Core" , "Java Core Description" ),
            new Topic("Java Script","JavaScript" , "JavaScript Description")
    ));



    public void addTopic(Topic topic) {
        topics.add(topic);

    }

    public List<Topic> getAllTopics(){
        return topics ;
    }


    public Topic getTopic(String id){
//       return topics.iterator().next().getId().equals(id);
        return topics.stream().filter(topic-> topic.getId().equals(id)).findFirst().get();

    }

    public void updateTopic(Topic topic , String id) {
        for(int i=0 ; i<topics.size(); i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i,topic);

            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t ->t.getId().equals(id));
//        for(int i =0 ; i<topics.size();i++){
//            Topic x = topics.get(i);
//            if(x.getId().equals(id)){
//                topics.remove(x);
//
//            }
//        }
    }
}
