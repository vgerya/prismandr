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
public class Next {
    @XmlElement(name = "remaining-count")
    private long remainingCount;
    @XmlElement(name = "query-params")
    private QueryParams queryParams;

    public Next() {
    }

    public long getRemainingCount() {
        return remainingCount;
    }

    public void setRemainingCount(long remainingCount) {
        this.remainingCount = remainingCount;
    }

    public QueryParams getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(QueryParams queryParams) {
        this.queryParams = queryParams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Next next = (Next) o;

        if (remainingCount != next.remainingCount) return false;
        if (queryParams != null ? !queryParams.equals(next.queryParams) : next.queryParams != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (remainingCount ^ (remainingCount >>> 32));
        result = 31 * result + (queryParams != null ? queryParams.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("remainingCount", remainingCount)
                .append("queryParams", queryParams)
                .toString();
    }
}
