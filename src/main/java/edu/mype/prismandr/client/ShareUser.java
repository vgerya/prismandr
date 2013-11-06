package edu.mype.prismandr.client;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URL;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShareUser extends TitledItem {
    @XmlElement(name = "display-key", required = false)
    private String displayKey;
    private String name;
    @XmlElement(name = "img")
    private URL image;

    public ShareUser() {
    }

    public String getDisplayKey() {
        return displayKey;
    }

    public void setDisplayKey(final String displayKey) {
        this.displayKey = displayKey;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public URL getImage() {
        return image;
    }

    public void setImage(final URL image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("displayKey", displayKey)
                .append("name", name)
                .append("image", image)
                .toString();
    }
}
