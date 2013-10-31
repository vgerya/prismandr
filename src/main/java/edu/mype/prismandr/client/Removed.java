package edu.mype.prismandr.client;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
public class Removed {
    @XmlElement(name = "remaining-count")
    private long remainingCount;
}
