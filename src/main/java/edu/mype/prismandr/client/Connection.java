package edu.mype.prismandr.client;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vitaliy Gerya
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Connection {
    @XmlElement(name = "prismatic-actions")
    private List<Action> prismaticActions = new LinkedList<>();
    @XmlElement(name = "external-actions")
    private List<Action> externalActions = new LinkedList<>();
    private List<TitledItem> interests = new LinkedList<>();

    public Connection() {
    }

    public List<Action> getPrismaticActions() {
        return prismaticActions;
    }

    public void setPrismaticActions(List<Action> prismaticActions) {
        this.prismaticActions = prismaticActions;
    }

    public List<Action> getExternalActions() {
        return externalActions;
    }

    public void setExternalActions(List<Action> externalActions) {
        this.externalActions = externalActions;
    }

    public List<TitledItem> getInterests() {
        return interests;
    }

    public void setInterests(List<TitledItem> interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("prismaticActions", prismaticActions)
                .append("externalActions", externalActions)
                .append("interests", interests)
                .toString();
    }
}
