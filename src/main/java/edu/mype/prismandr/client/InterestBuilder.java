package edu.mype.prismandr.client;

public class InterestBuilder {
    private String description;
    private String key;
    private String title;
    private String type;

    public InterestBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public InterestBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    public InterestBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public InterestBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Interest createInterest() {
        return new Interest(description, key, title, type);
    }
}