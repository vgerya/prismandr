package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
public class Post {
    private String id;
    private int start;
    private Interest interest;
    private Next next;
    private Removed removed;
    @XmlElement(name = "related-interests")
    private RelatedInterests relatedInterests;
    @XmlElement(name = "docs")
    private List<Article> articles = new LinkedList<>();

    public Post() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public Next getNext() {
        return next;
    }

    public void setNext(Next next) {
        this.next = next;
    }

    public Removed getRemoved() {
        return removed;
    }

    public void setRemoved(Removed removed) {
        this.removed = removed;
    }

    public RelatedInterests getRelatedInterests() {
        return relatedInterests;
    }

    public void setRelatedInterests(RelatedInterests relatedInterests) {
        this.relatedInterests = relatedInterests;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("start", start)
                .append("interest", interest)
                .append("next", next)
                .append("removed", removed)
                .append("relatedInterests", relatedInterests)
                .append("articles", articles)
                .toString();
    }
}
