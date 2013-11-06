package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Size {
    private long width;
    private long height;

    public Size() {
    }

    public Size(final long width, final long height) {
        this.width = width;
        this.height = height;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(final long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(final long height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("width", width)
                .append("height", height)
                .toString();
    }
}
