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
public class TitledItem extends Item {
    private String title;

    public TitledItem() {
    }

    public TitledItem(String key, String type, String title) {
        super(key, type);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("title", title)
                .toString();
    }
}
