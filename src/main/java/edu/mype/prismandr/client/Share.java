package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.*;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Share {
    @XmlAttribute(name = " ")
    private ShareUser user;
    @XmlElement(name = "")
    private UserShareAction userShareAction;

    public Share() {
    }

    public Share(ShareUser user, UserShareAction userShareAction) {
        this.user = user;
        this.userShareAction = userShareAction;
    }

    public ShareUser getUser() {
        return user;
    }

    public void setUser(ShareUser user) {
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

    public static class ShareBuilder {
        private ShareUser user;
        private UserShareAction userShareAction;

        public ShareBuilder setUser(ShareUser user) {
            this.user = user;
            return this;
        }

        public ShareBuilder setUserShareAction(UserShareAction userShareAction) {
            this.userShareAction = userShareAction;
            return this;
        }

        public Share createShare() {
            return new Share(user, userShareAction);
        }
    }
}
