package io.javabrains.courses;


import io.javabrains.springbootstarter.topics.Topic;
import io.javabrains.springbootstarter.topics.TopicRepository;
import io.javabrains.springbootstarter.topics.TopicService;
import org.hibernate.annotations.ManyToAny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @ManyToOne
    @Autowired
    private CourseRepository courseRepository;

//    private List<Course> courses = new ArrayList<>(Arrays.asList(
//            new Course("Spring", "Spring Framework", "Spring Framework Description"),
//            new Course("Java", "Java Core", "Java Core Description"),
//            new Course("Java Script", "JavaScript", "JavaScript Description")
//    ));


    public void addCourse(Course course) {
//        courses.add(course);
        courseRepository.save(course);

    }

    public List<Course> getAllCourses(String TopicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(TopicId).forEach(courses::add);
        return courses;


//        return (List<Course>) courseRepository.findAll();


    }


    public Optional<Course> getCourse(String id) {
//       return courses.iterator().next().getId().equals(id);
//        return courses.stream().filter(topic-> topic.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id);

    }

    public void updateCourse(Course course) {

////        for(int i=0 ; i<courses.size(); i++){
////            Course t = courses.get(i);
////            if(t.getId().equals(id)){
////                courses.set(i,course);
////
////            }
////        }
//       for(int i =0 ;i<courses.size();i++){
//           while(courses.iterator().hasNext()){
//               if(courses.get(i).getId().equals(id)){
//                   courseRepository.sa
//               }else{
//                   course
//               }
//
//           }
//       }

        courseRepository.save(course);

//        System.out.println(course.toString());


    }

    public void deleteCourse(String id) {
//        courses.removeIf(t -> t.getId().equals(id));

//        for(int i =0 ; i<courses.size();i++){
//            Course x = courses.get(i);
//            if(x.getId().equals(id)){
//                courses.remove(x);
//
//            }
//        }

        courseRepository.deleteById(id);
    }
}
