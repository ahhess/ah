package bwbv.rlt.client.ui.widget;

import bwbv.rlt.client.ClientState;
import bwbv.rlt.client.service.ServiceRegistry;

import com.google.gwt.user.client.ui.Composite;

/**
 * base class for all Panes in our app
 * 
 * Borrowed from Beginning Google Web Toolkit book
 */
public abstract class Pane extends Composite {

    private final ServiceRegistry serviceRegistry;
    private final ClientState clientState;

    /**
     * @param serviceRegistry The service registry each pane has access to.
     */
    protected Pane(ClientState clientState, ServiceRegistry serviceRegistry) {
        this.serviceRegistry = serviceRegistry;
        this.clientState = clientState;
    }
    
    /**
     * 
     * @return The service registry associated with this pane.
     */
    protected ServiceRegistry getServiceRegistry() {
        if (serviceRegistry == null) {
            throw new RuntimeException("serviceRegistry state in uninitialized");
        }
        return serviceRegistry;
    }
    
    public ClientState getClientState() {
        if (clientState == null) {
            throw new RuntimeException("client state in uninitialized");
        }
        return clientState;
    }
}
