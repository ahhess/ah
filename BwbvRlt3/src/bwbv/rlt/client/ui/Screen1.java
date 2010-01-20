package bwbv.rlt.client.ui;

import java.util.ArrayList;

import bwbv.rlt.client.ClientState;
import bwbv.rlt.client.domain.Candidate;
import bwbv.rlt.client.service.ServiceRegistry;
import bwbv.rlt.client.service.TestServiceFactory;
import bwbv.rlt.client.ui.widget.Pane;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;


public class Screen1 extends Pane {

	private ListBox listBox;

	public Screen1(ClientState clientState, ServiceRegistry serviceRegistry) {
        super(clientState, serviceRegistry);
        
		//containing panel
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
		horizontalPanel.setWidth("25%");

		// buttons
		VerticalPanel buttonsPanel = new VerticalPanel();
		buttonsPanel.setSpacing(18);
		Button hiButton = new Button("Say Hi...");
		hiButton.setWidth("100");
		Button complimentMeButton = new Button("Compliment");
		complimentMeButton.setWidth("100");

		buttonsPanel.add(hiButton);
		buttonsPanel.add(complimentMeButton);

		horizontalPanel.add(buttonsPanel);

		// list
		VerticalPanel listPanel = new VerticalPanel();
		listPanel.add(new Label("Candidates"));
		horizontalPanel.add(listPanel);
		listBox = new ListBox();
		populateCandidatesList();
		listBox.setVisibleItemCount(10);

		listPanel.add(listBox);
		
		Button deleteButton = new Button("Delete...");
		deleteButton.setWidth("100");

		listPanel.add(deleteButton);
		
		//button listeners
		complimentMeButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				callSimpleRemoteService();
			}
		});
		
		hiButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				if (listBox.getSelectedIndex() == -1) {
					callTestService("Hi Nobody");
				}
				else {	
					callTestService("Hi " + listBox.getItemText(listBox.getSelectedIndex()));
				}
			}
		});
		
		deleteButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				listBox.removeItem(listBox.getSelectedIndex());
			}
		});
		
		
		initWidget(horizontalPanel);
	}

	void callTestService(String message) {
//		 getServiceRegistry().getTestService().myMethod(message, new AsyncCallback<String>() {
		TestServiceFactory.getService().myMethod(message, new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				Window.alert("RPC failed.");
			}
			public void onSuccess(String result) {
				Window.alert("Recieved " + result);
			}
		});
	}
	
	void callSimpleRemoteService() {
		getServiceRegistry().getSampleRemoteService().doComplimentMe(new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				Window.alert("RPC failed.");
			}
			public void onSuccess(String result) {
				Window.alert("Recieved " + result);
			}
		});
	}
	
	void populateCandidatesList() {
//		getServiceRegistry().getTestService().getCandidates(new AsyncCallback<ArrayList<Candidate>>() {
		TestServiceFactory.getService().getCandidates(new AsyncCallback<ArrayList<Candidate>>() {
			public void onFailure(Throwable caught) {
				Window.alert("RPC failed.");
			}

			public void onSuccess(ArrayList<Candidate> candidates) {
				for (Candidate candidate : candidates) {
					listBox.addItem(candidate.getName());
				}
			}
		});
	}
	

}
