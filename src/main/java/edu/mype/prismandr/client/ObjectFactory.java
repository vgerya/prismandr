package edu.mype.prismandr.client;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * @author Vitaliy Gerya
 */
@XmlRegistry
public class ObjectFactory {
    public UserCredential createUserCredential() {
        return new UserCredential();
    }
}
