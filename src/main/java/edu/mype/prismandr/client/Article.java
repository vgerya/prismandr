package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
    private Item related;
    @XmlElement(name = "prismatic-activity")
    private Activity activity;
    @XmlElement(name = "first-degree-connections")
    private Connection firstDegreeConnections;
    private List<Image> images = new LinkedList<>();
    private Author author;
    private Commerce commerce;
    private String title;
    private URL url;
    private Feed feed;
    @XmlElement(name = "prismatic-shares")
    private List<List<Object>> prismaticShares = new LinkedList<>();
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

    public Article(final long id, final String text, final long date, final Item related, final Activity activity, final Connection firstDegreeConnections, final List<Image> images, final Author author, final Commerce commerce, final String title, final URL url, final Feed feed, final List<List<Object>> prismaticShares, final List<Comment> comments, final Share userShareIds, final List<Item> homeInterests, final long numShares, final List<TitledItem> topics) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.related = related;
        this.activity = activity;
        this.firstDegreeConnections = firstDegreeConnections;
        this.images = images;
        this.author = author;
        this.commerce = commerce;
        this.title = title;
        this.url = url;
        this.feed = feed;
        this.prismaticShares = prismaticShares;
        this.comments = comments;
        this.userShareIds = userShareIds;
        this.homeInterests = homeInterests;
        this.numShares = numShares;
        this.topics = topics;
    }

    public Commerce getCommerce() {
        return commerce;
    }

    public void setCommerce(final Commerce commerce) {
        this.commerce = commerce;
    }

    public Item getRelated() {
        return related;
    }

    public void setRelated(Item related) {
        this.related = related;
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

    public Connection getFirstDegreeConnections() {
        return firstDegreeConnections;
    }

    public void setFirstDegreeConnections(Connection firstDegreeConnections) {
        this.firstDegreeConnections = firstDegreeConnections;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public List<List<Object>> getPrismaticShares() {
        return prismaticShares;
    }

    public void setPrismaticShares(List<List<Object>> prismaticShares) {
        this.prismaticShares = prismaticShares;
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
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("text", text)
                .append("date", date)
                .append("related", related)
                .append("activity", activity)
                .append("firstDegreeConnections", firstDegreeConnections)
                .append("images", images)
                .append("author", author)
                .append("commerce", commerce)
                .append("title", title)
                .append("url", url)
                .append("feed", feed)
                .append("prismaticShares", prismaticShares)
                .append("comments", comments)
                .append("userShareIds", userShareIds)
                .append("homeInterests", homeInterests)
                .append("numShares", numShares)
                .append("topics", topics)
                .toString();
    }

    public static class ArticleBuilder {
        private long id;
        private String text;
        private long date;
        private Item related;
        private Activity activity;
        private Connection firstDegreeConnections;
        private List<Image> images;
        private Author author;
        private Commerce commerce;
        private String title;
        private URL url;
        private Feed feed;
        private List<List<Object>> prismaticShares = new ArrayList<>();
        private List<Comment> comments;
        private Share userShareIds;
        private List<Item> homeInterests;
        private long numShares;
        private List<TitledItem> topics;

        public ArticleBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public ArticleBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public ArticleBuilder setDate(long date) {
            this.date = date;
            return this;
        }

        public ArticleBuilder setRelated(Item related) {
            this.related = related;
            return this;
        }

        public ArticleBuilder setActivity(Activity activity) {
            this.activity = activity;
            return this;
        }

        public ArticleBuilder setFirstDegreeConnections(Connection firstDegreeConnections) {
            this.firstDegreeConnections = firstDegreeConnections;
            return this;
        }

        public ArticleBuilder setImages(List<Image> images) {
            this.images = images;
            return this;
        }

        public ArticleBuilder setAuthor(Author author) {
            this.author = author;
            return this;
        }

        public ArticleBuilder setCommerce(Commerce commerce) {
            this.commerce = commerce;
            return this;
        }

        public ArticleBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ArticleBuilder setUrl(URL url) {
            this.url = url;
            return this;
        }

        public ArticleBuilder setFeed(Feed feed) {
            this.feed = feed;
            return this;
        }

        public ArticleBuilder setPrismaticShares(List<List<Object>> prismaticShares) {
            this.prismaticShares = prismaticShares;
            return this;
        }

        public ArticleBuilder addPrismaticShares(Share... share) {
            this.prismaticShares.get(0).addAll(Arrays.asList(share));
            return this;
        }

        // TODO need fine API for set and get
        public ArticleBuilder addPrismaticShares(ShareUser share, UserShareAction action) {
            this.prismaticShares.add(Arrays.asList(share, action));
            return this;
        }

        public ArticleBuilder setComments(List<Comment> comments) {
            this.comments = comments;
            return this;
        }

        public ArticleBuilder setUserShareIds(Share userShareIds) {
            this.userShareIds = userShareIds;
            return this;
        }

        public ArticleBuilder setHomeInterests(List<Item> homeInterests) {
            this.homeInterests = homeInterests;
            return this;
        }

        public ArticleBuilder setNumShares(long numShares) {
            this.numShares = numShares;
            return this;
        }

        public ArticleBuilder setTopics(List<TitledItem> topics) {
            this.topics = topics;
            return this;
        }

        public Article createArticle() {
            return new Article(id, text, date, related, activity, firstDegreeConnections, images, author, commerce, title, url, feed, prismaticShares, comments, userShareIds, homeInterests, numShares, topics);
        }
    }

}
