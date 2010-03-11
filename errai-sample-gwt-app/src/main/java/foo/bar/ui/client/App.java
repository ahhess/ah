package foo.bar.ui.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class App implements EntryPoint
{
//    private MessageBus bus = ErraiBus.get();
//    private ShoutboxService shoutbox;

    public void onModuleLoad() {
//    	shoutbox = new ShoutboxService();
    	GWT.log("errai-sample-gwt-app App.onModuleLoad() ...", null);
    }
}
