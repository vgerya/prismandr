package edu.mype.prismandr.client;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
public class QueryParams {
    private boolean subpage;
    @XmlElement(name = "last-feed-id")
    private String lastFeedID;
    @XmlElement(name = "first-article-idx")
    private long firstArticleIdx;
    @XmlElement(name = "last-article-idx")
    private long lastArticleIdx;
}
