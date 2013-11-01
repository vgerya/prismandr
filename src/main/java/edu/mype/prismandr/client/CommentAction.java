package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CommentAction {
    private List<String> items = new LinkedList<>();
    @XmlElement(name = "remaining-count")
    private long remainingCount;

    public CommentAction() {
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
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
                .append("items", items)
                .append("remainingCount", remainingCount)
                .toString();
    }
}
