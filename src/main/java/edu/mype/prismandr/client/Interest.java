package edu.mype.prismandr.client;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
public class Interest extends TitledItem {
    @XmlElement(name = "des")
    private String description;

    public Interest() {
    }

    public Interest(String description, String key, String title, String type) {
        super(key, title, type);
        this.description = description;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Interest interest = (Interest) o;

        if (description != null ? !description.equals(interest.description) : interest.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("description", description)
                .toString();
    }

    public static class InterestBuilder {
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
}
