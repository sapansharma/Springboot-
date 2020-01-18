package io.javabrains.springbootstarter.topics;

import io.javabrains.courses.Course;

import javax.persistence.*;
import java.util.List;

//@Table(name ="Course")

@Entity
public class Topic {

    public Topic() {
    }

    @Id
    private String id ;
    private String name ;
    private String description;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Topic(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Topic(String id){
        this.id=id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
