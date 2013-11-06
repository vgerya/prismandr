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

    public Interest(final String description, final String key, final String title, final String type) {
        super(key, title, type);
        this.description = description;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
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

        public InterestBuilder setDescription(final String description) {
            this.description = description;
            return this;
        }

        public InterestBuilder setKey(final String key) {
            this.key = key;
            return this;
        }

        public InterestBuilder setTitle(final String title) {
            this.title = title;
            return this;
        }

        public InterestBuilder setType(final String type) {
            this.type = type;
            return this;
        }

        public Interest createInterest() {
            return new Interest(description, key, title, type);
        }
    }
}
