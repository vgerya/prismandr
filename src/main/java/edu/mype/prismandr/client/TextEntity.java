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
public class TextEntity {
    @XmlElement(name = "user-mentions")
    private List<String> userMentions = new LinkedList<>();

    public TextEntity() {
    }

    public List<String> getUserMentions() {
        return userMentions;
    }

    public void setUserMentions(List<String> userMentions) {
        this.userMentions = userMentions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("userMentions", userMentions)
                .toString();
    }
}
