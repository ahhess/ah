package foo.bar.ui.client;

import org.jboss.errai.bus.client.ErraiBus;
import org.jboss.errai.bus.client.MessageBus;
import org.jboss.errai.workspaces.client.svc.shoutbox.ShoutboxService;

import com.google.gwt.core.client.EntryPoint;

public class App implements EntryPoint
{
    private MessageBus bus = ErraiBus.get();
    private ShoutboxService shoutbox;

    public void onModuleLoad() {
    	shoutbox = new ShoutboxService();
    }
}
