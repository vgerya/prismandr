package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserCredential {
    private String handle;
    private String password;

    public UserCredential(final String handle, final String password) {
        this.handle = handle;
        this.password = password;
    }

    public UserCredential() {

    }

    public String getHandle() {
        return handle;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("handle", handle)
                .append("password", password)
                .toString();
    }
}
