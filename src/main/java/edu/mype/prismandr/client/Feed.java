package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Feed extends TitledItem {
    @XmlElement(name = "img")
    private String image;
    @XmlElement(name = "highres-img")
    private String highResImage;
    private String displayType;
    // TODO replace long with Date
    private long since;

    public Feed() {
    }

    public Feed(String key, String type, String title, String image, String highResImage, String displayType, long since) {
        super(key, type, title);
        this.image = image;
        this.highResImage = highResImage;
        this.displayType = displayType;
        this.since = since;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public long getSince() {
        return since;
    }

    public void setSince(long since) {
        this.since = since;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHighResImage() {
        return highResImage;
    }

    public void setHighResImage(String highResImage) {
        this.highResImage = highResImage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("image", image)
                .append("highResImage", highResImage)
                .append("displayType", displayType)
                .append("since", since)
                .toString();
    }
}
