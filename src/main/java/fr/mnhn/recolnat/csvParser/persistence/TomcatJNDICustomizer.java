package fr.mnhn.recolnat.csvParser.persistence;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.sessions.Connector;
import org.eclipse.persistence.sessions.JNDIConnector;
import org.eclipse.persistence.sessions.Session;

public class TomcatJNDICustomizer implements SessionCustomizer {

    public void customize( Session session ) throws Exception {
     	Connector connect = session.getLogin().getConnector();
    	if(connect instanceof JNDIConnector) {
    		JNDIConnector connector = (JNDIConnector) connect;
    		Context initCtx = new InitialContext();
    		Context envCtx = (Context) initCtx.lookup( "java:comp/env" );
    		connector.setContext( envCtx );
    	}
    }

}
