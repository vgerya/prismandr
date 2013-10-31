package edu.mype.prismandr.client;

import com.sun.xml.txw2.annotation.XmlElement;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author Vitaliy Gerya
 */
@XmlElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    private String key;
    private String type;

    public Item() {
    }

    public Item(String key, String type) {
        this.key = key;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("key", key)
                .append("type", type)
                .toString();
    }
}
