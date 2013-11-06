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
public class RelatedInterests {
    @XmlElement(name = "interests")
    private BaseInterest interests;
    @XmlElement(name = "following")
    private BaseInterest following;

    public RelatedInterests() {
    }

    public BaseInterest getInterests() {
        return interests;
    }

    public void setInterests(final BaseInterest interests) {
        this.interests = interests;
    }

    public BaseInterest getFollowing() {
        return following;
    }

    public void setFollowing(final BaseInterest following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("interests", interests)
                .append("following", following)
                .toString();
    }
}
