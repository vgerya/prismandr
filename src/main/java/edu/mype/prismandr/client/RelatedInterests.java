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

    public void setInterests(BaseInterest interests) {
        this.interests = interests;
    }

    public BaseInterest getFollowing() {
        return following;
    }

    public void setFollowing(BaseInterest following) {
        this.following = following;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelatedInterests that = (RelatedInterests) o;

        if (following != null ? !following.equals(that.following) : that.following != null) return false;
        if (interests != null ? !interests.equals(that.interests) : that.interests != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = interests != null ? interests.hashCode() : 0;
        result = 31 * result + (following != null ? following.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("interests", interests)
                .append("following", following)
                .toString();
    }
}
