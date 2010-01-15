package foo.bar.ui.client.ui;

import java.util.ArrayList;
import java.util.Date;

import org.jboss.errai.bus.client.ErraiBus;
import org.jboss.errai.bus.client.MessageBuilder;
import org.jboss.errai.bus.client.MessageBus;
import org.jboss.errai.bus.client.RemoteCallback;
import org.jboss.errai.common.client.framework.WSComponent;
import org.jboss.errai.widgets.client.mapping.ErraiWidgetBinding;
import org.jboss.errai.workspaces.client.framework.annotations.LoadTool;
import org.jboss.errai.workspaces.client.layout.WorkPanel;
import org.jboss.errai.workspaces.client.svc.shoutbox.Shoutbox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.istec.pls.base.domain.Workplace;

@LoadTool(name = "HelloWorld", group = "App")
public class HelloWorldTool implements WSComponent {

	public Widget getWidget() {
		return new HelloWorldWidget();
	}

	public static class HelloWorldWidget extends Composite {

		/**
		 * Do errai widget binding boilerplate.
		 */
		@UiTemplate("HelloWorldWidget.ui.xml")
		interface Binder extends UiBinder<Panel, HelloWorldWidget> {
		}

		private static final Binder binder = GWT.create(Binder.class);

		interface WidgetBinding extends ErraiWidgetBinding<HelloWorldWidget> {
		}

		private static WidgetBinding widgetBindings = GWT
				.create(WidgetBinding.class);

		private final MessageBus bus = ErraiBus.get();
		private Shoutbox shoutbox = new Shoutbox();

		@UiField
		WorkPanel workPanel;

		@UiField
		TextBox textBox;

		@UiField
		Button clickMe;

		@UiField
		Button clickMe2;
		
		@UiField
		Button bGetWp;

		@UiField
		Label label;

		public HelloWorldWidget() {
			super();
			initWidget(binder.createAndBindUi(this));
			widgetBindings.mapAll(this);
		}

		@UiHandler("clickMe")
		public void clickMeSubmit(ClickEvent event) {
			MessageBuilder.createMessage().toSubject("HelloWorldService")
					.signalling().with("text", getMsg()).noErrorHandling()
					.sendNowWith(bus);
		}

		@UiHandler("clickMe2")
		public void clickMe2Submit(ClickEvent event) {
			MessageBuilder.createCall().call("MyService").endpoint("hello",
					getMsg()).respondTo(String.class,
					new RemoteCallback<String>() {
						public void callback(String result) {
							if (result == null) {
								result = "No results.";
							}
							label.setText(result);
						}
					}).noErrorHandling().sendNowWith(bus);
		}
		
		@UiHandler("bGetWp")
		public void bGetWpClicked(ClickEvent event) {
			MessageBuilder.createCall().call("MyService")
					.endpoint("getArbeitsplaetze")
					.respondTo(new RemoteCallback<ArrayList<Workplace>>() {
						public void callback(ArrayList<Workplace> result) {
							if (result != null && result.size()>0) {
								Workplace ap = (Workplace)result.get(0);
								label.setText(ap.getBezeichnung());
							} else {
								label.setText("kein Ergebnis");
							}
						}
					}).noErrorHandling().sendNowWith(bus);
		}

		private String getMsg() {
			return new Date().toString() + ": " + textBox.getText();
		}
	}
}
