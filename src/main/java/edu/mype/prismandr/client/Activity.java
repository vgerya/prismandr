package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;

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

    public void setSave(long save) {
        this.save = save;
    }

    public long getComment() {
        return comment;
    }

    public void setComment(long comment) {
        this.comment = comment;
    }

    public long getRemove() {
        return remove;
    }

    public void setRemove(long remove) {
        this.remove = remove;
    }

    public long getShare() {
        return share;
    }

    public void setShare(long share) {
        this.share = share;
    }

    public long getEmail() {
        return email;
    }

    public void setEmail(long email) {
        this.email = email;
    }

    public long getBookmark() {
        return bookmark;
    }

    public void setBookmark(long bookmark) {
        this.bookmark = bookmark;
    }

    public long getClick() {
        return click;
    }

    public void setClick(long click) {
        this.click = click;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (bookmark != activity.bookmark) return false;
        if (click != activity.click) return false;
        if (comment != activity.comment) return false;
        if (email != activity.email) return false;
        if (remove != activity.remove) return false;
        if (save != activity.save) return false;
        if (share != activity.share) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (save ^ (save >>> 32));
        result = 31 * result + (int) (comment ^ (comment >>> 32));
        result = 31 * result + (int) (remove ^ (remove >>> 32));
        result = 31 * result + (int) (share ^ (share >>> 32));
        result = 31 * result + (int) (email ^ (email >>> 32));
        result = 31 * result + (int) (bookmark ^ (bookmark >>> 32));
        result = 31 * result + (int) (click ^ (click >>> 32));
        return result;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
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
