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
public class Comment {
    private long id;
    private String text;
    private long date;
    @XmlElement(name = "text-entities")
    private TextEntity textEntety;
    @XmlElement(name = "action-counts")
    private ActionCount actionCount;
    private String type;
    @XmlElement(name = "parent-comment-id")
    private long parentCommentId;
    private User user;
    @XmlElement(name = "user-share-ids")
    private Share userShareIds;
    @XmlElement(name = "actions")
    private CommentAction action;

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public long getDate() {
        return date;
    }

    public void setDate(final long date) {
        this.date = date;
    }

    public TextEntity getTextEntety() {
        return textEntety;
    }

    public void setTextEntety(final TextEntity textEntety) {
        this.textEntety = textEntety;
    }

    public ActionCount getActionCount() {
        return actionCount;
    }

    public void setActionCount(final ActionCount actionCount) {
        this.actionCount = actionCount;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(final long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Share getUserShareIds() {
        return userShareIds;
    }

    public void setUserShareIds(final Share userShareIds) {
        this.userShareIds = userShareIds;
    }

    public CommentAction getAction() {
        return action;
    }

    public void setAction(final CommentAction action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("text", text)
                .append("date", date)
                .append("textEntety", textEntety)
                .append("actionCount", actionCount)
                .append("type", type)
                .append("parentCommentId", parentCommentId)
                .append("user", user)
                .append("userShareIds", userShareIds)
                .append("action", action)
                .toString();
    }
}
