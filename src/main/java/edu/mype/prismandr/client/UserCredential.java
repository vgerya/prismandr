package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement(name = "")
public class UserCredential {
    private String handle;
    private String password;

    public UserCredential(String handle, String password) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCredential that = (UserCredential) o;

        if (!handle.equals(that.handle)) return false;
        if (!password.equals(that.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = handle.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("handle", handle)
                .append("password", password)
                .toString();
    }
}
