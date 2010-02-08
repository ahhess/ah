package bwbv.rlt.client.ui;

import bwbv.rlt.client.domain.Rlt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Entry point and flow control of our app.
 */
public class MainPane extends Composite {

	private static final String RLTSURL = "/json";

	private HeaderPane headerPane;
	private StatusBarPane statusBarPane;
	private SimplePanel centerPane;
	private MenuPanel menuPanel; // menu

	private JsArray<Rlt> rlts = null;

	public MainPane() {

		DockPanel mainPanel = new DockPanel();
		mainPanel.setBorderWidth(5);
		mainPanel.setSize("100%", "100%");

		headerPane = new HeaderPane("GWT Maven Sample");
		mainPanel.add(headerPane, DockPanel.NORTH);
		mainPanel.setCellHeight(headerPane, "30px");
		mainPanel.setCellHorizontalAlignment(headerPane, DockPanel.ALIGN_CENTER);
		mainPanel.setCellVerticalAlignment(headerPane, DockPanel.ALIGN_MIDDLE);

		statusBarPane = new StatusBarPane();
		mainPanel.add(statusBarPane, DockPanel.SOUTH);
		mainPanel.setCellHeight(statusBarPane, "25px");
		mainPanel.setCellHorizontalAlignment(statusBarPane, DockPanel.ALIGN_CENTER);
		mainPanel.setCellVerticalAlignment(statusBarPane, DockPanel.ALIGN_MIDDLE);

		HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();
		horizontalSplitPanel.setSplitPosition("150px");
		centerPane = new SimplePanel();

		centerPane.add(new Label("Bitte RLT ausw&auml;hlen"));
		horizontalSplitPanel.setRightWidget(centerPane);
		menuPanel = new MenuPanel();

		horizontalSplitPanel.setLeftWidget(menuPanel);
		mainPanel.add(horizontalSplitPanel, DockPanel.CENTER);

		showRlts();

		initWidget(mainPanel);
	}

	/**
	 * Zeigt das Rlt mit Details und den Disz. als Tabs an
	 */
	public void showRlt(Rlt rlt) {
		DecoratedTabPanel tabPanel = new DecoratedTabPanel();
		tabPanel.setWidth("100%");
		// tabPanel.setAnimationEnabled(true);
		tabPanel.add(new RltInfoPanel(rlt), "Info");
		tabPanel.selectTab(0);
		if (rlt.getDiszs() != null) {
			for (String disz : rlt.getDiszs()) {
				tabPanel.add(new HTML("coming soon ..."), disz);
			}
		}
		centerPane.setWidget(tabPanel);
	}

	public void showRlts() {

		// Send request to server and catch any errors.
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(RLTSURL));

		try {
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {
					Window.alert("Couldn't retrieve JSON:" + exception);
				}

				public void onResponseReceived(Request request, Response response) {
					if (200 == response.getStatusCode()) {
						GWT.log(response.getText(), null);
						fillMenu(response.getText());
					} else {
						Window.alert("Couldn't retrieve JSON (" + response.getStatusText() + ")");
					}
				}
			});
		} catch (RequestException e) {
			Window.alert("Couldn't retrieve JSON");
		}
	}

	public void fillMenu(String json) {
		menuPanel.fillMenu(this, asJsArray(json));
	}

	/**
	 * Convert the string of JSON into JavaScript object.
	 */
	private final native JsArray<Rlt> asJsArray(String json) /*-{
		return eval(json);
	}-*/;

}
