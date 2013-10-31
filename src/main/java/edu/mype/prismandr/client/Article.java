package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Article {
    private long id;
    private String text;
    private long date;
    @XmlElement(name = "prismatic-activity")
    private Activity activity;
    @XmlElement(name = "first-degree-connections")
    private Connection firstDegreeCponnections;
    private List<Image> images = new LinkedList<>();
    private Author author;
    private String commerce;
    private String title;
    private String url;
    private Feed feed;
    @XmlElement(name = "prismatic-shares")
    private List<Share> shares = new LinkedList<>();
    private List<Comment> comments = new LinkedList<>();
    @XmlElement(name = "user-share-ids")
    private Share userShareIds;
    @XmlElement(name = "home-interests")
    private List<Item> homeInterests = new LinkedList<>();
    @XmlElement(name = "num-shares")
    private long numShares;
    private List<TitledItem> topics = new LinkedList<>();

    public Article() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Connection getFirstDegreeCponnections() {
        return firstDegreeCponnections;
    }

    public void setFirstDegreeCponnections(Connection firstDegreeCponnections) {
        this.firstDegreeCponnections = firstDegreeCponnections;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getCommerce() {
        return commerce;
    }

    public void setCommerce(String commerce) {
        this.commerce = commerce;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Share getUserShareIds() {
        return userShareIds;
    }

    public void setUserShareIds(Share userShareIds) {
        this.userShareIds = userShareIds;
    }

    public List<Item> getHomeInterests() {
        return homeInterests;
    }

    public void setHomeInterests(List<Item> homeInterests) {
        this.homeInterests = homeInterests;
    }

    public long getNumShares() {
        return numShares;
    }

    public void setNumShares(long numShares) {
        this.numShares = numShares;
    }

    public List<TitledItem> getTopics() {
        return topics;
    }

    public void setTopics(List<TitledItem> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("text", text)
                .append("date", date)
                .append("activity", activity)
                .append("firstDegreeCponnections", firstDegreeCponnections)
                .append("images", images)
                .append("author", author)
                .append("commerce", commerce)
                .append("title", title)
                .append("url", url)
                .append("feed", feed)
                .append("shares", shares)
                .append("comments", comments)
                .append("userShareIds", userShareIds)
                .append("homeInterests", homeInterests)
                .append("numShares", numShares)
                .append("topics", topics)
                .toString();
    }
}
