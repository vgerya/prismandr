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
public class Share {
    @XmlElement(name = "")
    private User user;
    @XmlElement(name = "")
    private UserShareAction userShareAction;

    public Share() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User share) {
        this.user = user;
    }

    public UserShareAction getUserShareAction() {
        return userShareAction;
    }

    public void setUserShareAction(UserShareAction userShareAction) {
        this.userShareAction = userShareAction;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("user", user)
                .append("userShareAction", userShareAction)
                .toString();
    }
}
