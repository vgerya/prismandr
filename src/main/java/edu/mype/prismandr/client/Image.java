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
public class Image {
    @XmlElement(name = "in-div")
    private boolean inDiv;
    @XmlElement(name = "orig-size")
    private Size originalSize;
    private Size size;
    private String url;
    private double prob;

    public Image() {
    }

    public boolean isInDiv() {
        return inDiv;
    }

    public void setInDiv(boolean inDiv) {
        this.inDiv = inDiv;
    }

    public Size getOriginalSize() {
        return originalSize;
    }

    public void setOriginalSize(Size originalSize) {
        this.originalSize = originalSize;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("inDiv", inDiv)
                .append("originalSize", originalSize)
                .append("size", size)
                .append("url", url)
                .append("prob", prob)
                .toString();
    }
}
