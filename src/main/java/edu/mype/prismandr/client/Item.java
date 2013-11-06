package edu.mype.prismandr.client;

import com.sun.xml.txw2.annotation.XmlElement;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

    public Item(final Item item) {
        this.key = item.key;
        this.type = item.type;
    }

    public Item(final String key, final String type) {
        this.key = key;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("key", key).append("type", type)
                                                                          .toString();
    }
}
