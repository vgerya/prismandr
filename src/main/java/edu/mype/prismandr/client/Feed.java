package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Feed extends TitledItem {
    @XmlElement(name = "img")
    private URL image;
    @XmlElement(name = "highres-img")
    private URL highResImage;
    private String displayType;
    private List<String> explain = new LinkedList<>();
    // TODO replace long with Date
    private long since;
    private long priority;

    public Feed() {
    }

    public List<String> getExplain() {
        return explain;
    }

    public void setExplain(final List<String> explain) {
        this.explain = explain;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public Feed(String key, String type, String title, URL image, URL highResImage, String displayType, long since, long priority) {

        super(key, type, title);
        this.image = image;
        this.highResImage = highResImage;
        this.displayType = displayType;
        this.since = since;
        this.priority = priority;
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

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public URL getHighResImage() {
        return highResImage;
    }

    public void setHighResImage(URL highResImage) {
        this.highResImage = highResImage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("image", image)
                .append("highResImage", highResImage)
                .append("displayType", displayType)
                .append("explain", explain)
                .append("since", since)
                .append("priority", priority)
                .toString();
    }
}
