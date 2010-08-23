
package bwbv.rlt.client;

import bwbv.rlt.client.service.RltJsonServiceImpl;
import bwbv.rlt.client.service.RltService;
import bwbv.rlt.client.ui.MainPane;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.StatusCodeException;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * The entry point for the app.
 */
public class ClientMain implements EntryPoint {

	private SimplePanel main;
	private MainPane mainPane;

	public void onModuleLoad() {

        //get better exception handling
        setUncaughtExceptionHandler();
                
		ClientState clientState = new ClientState();
		RltService rltService = new RltJsonServiceImpl();
		ClientController controller = new ClientController(clientState, rltService);

        mainPane = new MainPane(clientState, controller);
        
        rltService.sendGetRltsRequest(clientState);

        main = new SimplePanel();
        main.setSize("100%", "100%");
        main.setWidget(mainPane);

        RootPanel.get().add(main);
        RootPanel.get("loading").setVisible(false);
	}


	/**
	 * better exception handling
	 */ 
    private void setUncaughtExceptionHandler() {
        GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public void onUncaughtException(Throwable e) {
                if (e.getCause() != null && e.getCause() instanceof StatusCodeException) {
                    GWT.log("Exception (server-side) :(", e);
                    Window.alert("Exception (server-side)");
                } else {
                    GWT.log("Exception :(", e);
                    Window.alert("Exception " + e.getMessage());
                }
            }
        });
    }

}
