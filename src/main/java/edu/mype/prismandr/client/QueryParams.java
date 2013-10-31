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
public class QueryParams {
    private boolean subpage;
    @XmlElement(name = "last-feed-id")
    private String lastFeedID;
    @XmlElement(name = "first-article-idx")
    private long firstArticleIdx;
    @XmlElement(name = "last-article-idx")
    private long lastArticleIdx;

    public QueryParams() {
    }

    public boolean isSubpage() {
        return subpage;
    }

    public void setSubpage(boolean subpage) {
        this.subpage = subpage;
    }

    public String getLastFeedID() {
        return lastFeedID;
    }

    public void setLastFeedID(String lastFeedID) {
        this.lastFeedID = lastFeedID;
    }

    public long getFirstArticleIdx() {
        return firstArticleIdx;
    }

    public void setFirstArticleIdx(long firstArticleIdx) {
        this.firstArticleIdx = firstArticleIdx;
    }

    public long getLastArticleIdx() {
        return lastArticleIdx;
    }

    public void setLastArticleIdx(long lastArticleIdx) {
        this.lastArticleIdx = lastArticleIdx;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("subpage", subpage)
                .append("lastFeedID", lastFeedID)
                .append("firstArticleIdx", firstArticleIdx)
                .append("lastArticleIdx", lastArticleIdx)
                .toString();
    }
}
