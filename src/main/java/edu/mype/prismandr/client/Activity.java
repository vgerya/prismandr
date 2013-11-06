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
public class Activity {
    private long save;
    private long comment;
    private long remove;
    private long share;
    private long email;
    private long bookmark;
    private long click;

    public Activity() {
    }

    public long getSave() {
        return save;
    }

    public void setSave(final long save) {
        this.save = save;
    }

    public long getComment() {
        return comment;
    }

    public void setComment(final long comment) {
        this.comment = comment;
    }

    public long getRemove() {
        return remove;
    }

    public void setRemove(final long remove) {
        this.remove = remove;
    }

    public long getShare() {
        return share;
    }

    public void setShare(final long share) {
        this.share = share;
    }

    public long getEmail() {
        return email;
    }

    public void setEmail(final long email) {
        this.email = email;
    }

    public long getBookmark() {
        return bookmark;
    }

    public void setBookmark(final long bookmark) {
        this.bookmark = bookmark;
    }

    public long getClick() {
        return click;
    }

    public void setClick(final long click) {
        this.click = click;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("save", save)
                .append("comment", comment)
                .append("remove", remove)
                .append("share", share)
                .append("email", email)
                .append("bookmark", bookmark)
                .append("click", click)
                .toString();
    }
}
