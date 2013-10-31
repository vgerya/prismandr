package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
public class NextToken {
    @XmlElement(name = "skip-ids")
    private List<Long> skipIds;
    private List<ViewedData> viewedData;

    public NextToken() {
    }

    public List<Long> getSkipIds() {
        return skipIds;
    }

    public void setSkipIds(List<Long> skipIds) {
        this.skipIds = skipIds;
    }

    public List<ViewedData> getViewedData() {
        return viewedData;
    }

    public void setViewedData(List<ViewedData> viewedData) {
        this.viewedData = viewedData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NextToken nextToken = (NextToken) o;

        if (skipIds != null ? !skipIds.equals(nextToken.skipIds) : nextToken.skipIds != null) return false;
        if (viewedData != null ? !viewedData.equals(nextToken.viewedData) : nextToken.viewedData != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skipIds != null ? skipIds.hashCode() : 0;
        result = 31 * result + (viewedData != null ? viewedData.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("skipIds", skipIds)
                .append("viewedData", viewedData)
                .toString();
    }
}
