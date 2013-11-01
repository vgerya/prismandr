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
public class ActionUser extends TitledItem {
    private String name;
    private String url;
    @XmlElement(name = "img")
    private String image;

    public ActionUser() {
    }

    public ActionUser(String key, String type, String title, String name, String title1, String image) {
        super(key, type, title);
        this.name = name;
        title = title1;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("url", url)
                .append("image", image)
                .toString();
    }
}
