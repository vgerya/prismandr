package edu.mype.prismandr.client;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
public class Post {
    private Interest interest;
//    private Next next;
    private String id;
    private int start;
//    private List<Document> docs;
}
