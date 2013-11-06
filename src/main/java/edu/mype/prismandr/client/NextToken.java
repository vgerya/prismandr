package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NextToken {
    @XmlElement(name = "skip-ids")
    private List<Long> skipIds;
    @XmlElement(name = "viewed-data")
    private List<ViewedData> viewedData;

    public NextToken() {
    }

    public NextToken(final List<Long> skipIds, final List<ViewedData> viewedData) {
        this.skipIds = skipIds;
        this.viewedData = viewedData;
    }

    public List<Long> getSkipIds() {
        return skipIds;
    }

    public void setSkipIds(final List<Long> skipIds) {
        this.skipIds = skipIds;
    }

    public List<ViewedData> getViewedData() {
        return viewedData;
    }

    public void setViewedData(final List<ViewedData> viewedData) {
        this.viewedData = viewedData;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("skipIds", skipIds)
                .append("viewedData", viewedData)
                .toString();
    }

    public static class NextTokenBuilder {
        private List<Long> skipIds = new LinkedList<>();
        private List<ViewedData> viewedData = new LinkedList<>();

        public NextTokenBuilder addSkipId(final Long skipId) {
            this.skipIds.add(skipId);
            return this;
        }

        public NextTokenBuilder addSkipIds(final Long ... skipIds) {
            this.skipIds.addAll(Arrays.asList(skipIds));
            return this;
        }

        public NextTokenBuilder addViewedData(final ViewedData viewedData) {
            this.viewedData.add(viewedData);
            return this;
        }

        public NextToken createNextToken() {
            return new NextToken(skipIds, viewedData);
        }
    }
}
