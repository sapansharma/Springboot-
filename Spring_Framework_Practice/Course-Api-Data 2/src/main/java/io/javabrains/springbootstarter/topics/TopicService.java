package io.javabrains.springbootstarter.topics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("Spring", "Spring Framework", "Spring Framework Description"),
//            new Topic("Java", "Java Core", "Java Core Description"),
//            new Topic("Java Script", "JavaScript", "JavaScript Description")
//    ));


    public void addTopic(Topic topic) {
//        courses.add(topic);
        topicRepository.save(topic);

    }

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        for (Topic topic : topicRepository.findAll()) {
            topics.add(topic);
        }
        return topics;

//        return (List<Course>) topicRepository.findAll();


    }


    public Optional<Topic> getTopic(String id) {
//       return courses.iterator().next().getId().equals(id);
//        return courses.stream().filter(topic-> topic.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);

    }

    public void updateTopic(Topic topic, String id) {
////        for(int i=0 ; i<courses.size(); i++){
////            Course t = courses.get(i);
////            if(t.getId().equals(id)){
////                courses.set(i,topic);
////
////            }
////        }
//       for(int i =0 ;i<courses.size();i++){
//           while(courses.iterator().hasNext()){
//               if(courses.get(i).getId().equals(id)){
//                   topicRepository.sa
//               }else{
//                   topic
//               }
//
//           }
//       }

        topic.setId(id);
        topicRepository.save(topic);

        System.out.println(topic.toString());
    }

    public void deleteTopic(String id) {
//        courses.removeIf(t -> t.getId().equals(id));

//        for(int i =0 ; i<courses.size();i++){
//            Course x = courses.get(i);
//            if(x.getId().equals(id)){
//                courses.remove(x);
//
//            }
//        }

        topicRepository.deleteById(id);
    }
}
