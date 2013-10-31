package edu.mype.prismandr.client;

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
    private List<Article> documents = new LinkedList<>();
}
