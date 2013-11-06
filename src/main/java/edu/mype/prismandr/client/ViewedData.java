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

    public ViewedData(final long documentId, final String feedId, final long dwell) {
        this.documentId = documentId;
        this.feedId = feedId;
        this.dwell = dwell;
    }

    public long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(final long documentId) {
        this.documentId = documentId;
    }

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(final String feedId) {
        this.feedId = feedId;
    }

    public long getDwell() {
        return dwell;
    }

    public void setDwell(final long dwell) {
        this.dwell = dwell;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("documentId", documentId)
                                                                          .append("feedId", feedId)
                                                                          .append("dwell", dwell).toString();
    }

    public static class ViewedDataBuilder {
        private long documentId;
        private String feedId;
        private long dwell;

        public ViewedDataBuilder setDocumentId(final long documentId) {
            this.documentId = documentId;
            return this;
        }

        public ViewedDataBuilder setFeedId(final String feedId) {
            this.feedId = feedId;
            return this;
        }

        public ViewedDataBuilder setDwell(final long dwell) {
            this.dwell = dwell;
            return this;
        }

        public ViewedData createViewedData() {
            return new ViewedData(documentId, feedId, dwell);
        }
    }
}
