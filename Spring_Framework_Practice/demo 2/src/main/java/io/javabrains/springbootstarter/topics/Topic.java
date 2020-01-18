package io.javabrains.springbootstarter.topics;


public class Topic {
    private String id ;
    private String name ;
    private String description;

    public Topic() {
    }

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
}
