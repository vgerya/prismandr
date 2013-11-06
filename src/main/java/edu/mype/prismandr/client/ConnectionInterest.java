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
public class ConnectionInterest extends TitledItem {
    @XmlElement(name = "img")
    // TODO testing of URL instead of String
    private URL image;
    @XmlElement(name = "highres-img")
    private URL highResImage;
    private long since;

    public ConnectionInterest() {
    }

    public URL getHighResImage() {
        return highResImage;
    }

    public void setHighResImage(final URL highResImage) {
        this.highResImage = highResImage;
    }

    public long getSince() {
        return since;
    }

    public void setSince(final long since) {
        this.since = since;
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
                .append("image", image)
                .append("highResImage", highResImage)
                .append("since", since)
                .toString();
    }
}
