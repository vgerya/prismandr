package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
public class Removed {
    @XmlElement(name = "remaining-count")
    private long remainingCount;

    public Removed() {
    }

    public long getRemainingCount() {
        return remainingCount;
    }

    public void setRemainingCount(long remainingCount) {
        this.remainingCount = remainingCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("remainingCount", remainingCount)
                .toString();
    }
}
