package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vitaliy Gerya
 *         <p/>
 *         "viewed-data":[
 *         {"doc-id":1382993499230,"feed-id":"news415024_51037420","dwell":0},
 *         {"doc-id":1383033721870,"feed-id":"news415024_51037420","dwell":0},
 *         {"doc-id":1382958106756,"feed-id":"news415024_51037420","dwell":0}]
 */
@XmlRootElement(name = "viewed-data")
@XmlAccessorType(XmlAccessType.FIELD)
public class ViewedData {
    @XmlElement(name = "doc-id")
    private long documentId;
    @XmlElement(name = "feed-id")
    private String feedId;
    private long dwell;

    public ViewedData() {
    }

    public ViewedData(long documentId, String feedId, long dwell) {
        this.documentId = documentId;
        this.feedId = feedId;
        this.dwell = dwell;
    }

    public long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public long getDwell() {
        return dwell;
    }

    public void setDwell(long dwell) {
        this.dwell = dwell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewedData that = (ViewedData) o;

        if (documentId != that.documentId) return false;
        if (dwell != that.dwell) return false;
        if (feedId != null ? !feedId.equals(that.feedId) : that.feedId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (documentId ^ (documentId >>> 32));
        result = 31 * result + (feedId != null ? feedId.hashCode() : 0);
        result = 31 * result + (int) (dwell ^ (dwell >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("documentId", documentId)
                .append("feedId", feedId)
                .append("dwell", dwell)
                .toString();
    }

    public static class ViewedDataBuilder {
        private long documentId;
        private String feedId;
        private long dwell;

        public ViewedDataBuilder setDocumentId(long documentId) {
            this.documentId = documentId;
            return this;
        }

        public ViewedDataBuilder setFeedId(String feedId) {
            this.feedId = feedId;
            return this;
        }

        public ViewedDataBuilder setDwell(long dwell) {
            this.dwell = dwell;
            return this;
        }

        public ViewedData createViewedData() {
            return new ViewedData(documentId, feedId, dwell);
        }
    }
}
