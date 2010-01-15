package foo.bar.ui.client;

import java.util.Date;

import org.jboss.errai.bus.client.ErraiBus;
import org.jboss.errai.bus.client.MessageBuilder;
import org.jboss.errai.bus.client.MessageBus;
import org.jboss.errai.bus.client.RemoteCallback;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class HelloWorldClient implements EntryPoint
{
    /**
     * Get an instance of the MessageBus
     */
    private MessageBus bus = ErraiBus.get();

    Button clickMe = new Button("Message to HelloWorldService");
    Button clickMe2 = new Button("Call MyService");
    TextBox textBox = new TextBox();
    Label label = new Label();

    public void onModuleLoad() {

        clickMe.addClickHandler(getClickMeHandler());
        clickMe2.addClickHandler(getClickMe2Handler());

        VerticalPanel panel = new VerticalPanel();
        panel.add(textBox);
        panel.add(clickMe);
        panel.add(clickMe2);
        panel.add(label);
        RootPanel.get().add(panel);
    }

	private String getMsg() {
		return new Date().toString() + ": " + textBox.getText();
	}
    
    /**
     * Register a click handler for the button.
     */
    private ClickHandler getClickMeHandler() {
    	return new ClickHandler() {
    		public void onClick(ClickEvent event) {
//				CommandMessage.create()
//                        .toSubject("HelloWorld")
//                        .sendNowWith(bus);

    			MessageBuilder.createMessage()
                    .toSubject("HelloWorldService")             // (1)
                    .signalling()                               // (2)
                    .with("text", getMsg())
                    .noErrorHandling()                          // (3)
                    .sendNowWith(bus);                          // (4)
    		}
    	};
    }

    /**
     * Register a click handler for the button.
     */
	private ClickHandler getClickMe2Handler() {
		return new ClickHandler() {
            public void onClick(ClickEvent event) {
				MessageBuilder.createCall()
		           .call("MyService")                                         // (1)
		           .endpoint("hello", getMsg())                     // (2)
		           .respondTo(String.class, new RemoteCallback<String>() {   // (3)
		               public void callback(String result) {
		                   if (result == null) {
		                       result = "No results.";
		                   }
//		                   Window.alert(resultsString);
		                   label.setText(result);
		               }
		           })
		           .noErrorHandling()
		           .sendNowWith(bus);
           }
        };
	}
}
