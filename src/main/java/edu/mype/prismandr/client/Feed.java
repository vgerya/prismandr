package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;

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

    public Feed() {
    }

    public Feed(String key, String title, String type, String image, String highResImage) {
        super(key, title, type);
        this.image = image;
        this.highResImage = highResImage;
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
        return new ToStringBuilder(this)
                .append("image", image)
                .append("highResImage", highResImage)
                .toString();
    }
}
