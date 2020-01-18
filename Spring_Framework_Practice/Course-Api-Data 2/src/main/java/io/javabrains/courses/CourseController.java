package io.javabrains.courses;

import io.javabrains.springbootstarter.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
   private CourseService Courseservice;

    @RequestMapping("/topics/{TopicId}/courses")
    public List<Course>  getAllCourses(@PathVariable("TopicId") String TopicId){
        return Courseservice.getAllCourses(TopicId);

    }

    @GetMapping("/topic/{TopicId}/course/{id}")
    public Optional<Course> getCourseById(@PathVariable("id") String id , @PathVariable("TopicId") String TopicId){
        return Courseservice.getCourse(id);
    }



   @RequestMapping(method=RequestMethod.POST , value = "/topics/{TopicId}/course")
    public void createCourse(@PathVariable("TopicId") String TopicId , @RequestBody Course course ){
        course.setTopic(new Topic(TopicId));
        Courseservice.addCourse(course);
    }


    //todo: Same problem as above function.
    @RequestMapping(method=RequestMethod.PUT , value = "/topics/{TopicId}/course/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable("id") String id , @PathVariable("TopicId") String TopicId ){
        course.setTopic(new Topic(TopicId));
        Courseservice.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{TopicId}/course/{id}")
    public void deleteCourse(@PathVariable("TopicId") String TopicId , @PathVariable("id") String id ){
        Courseservice.deleteCourse(id);

    }

}
