package bwbv.rlt.client.presenter;

import bwbv.rlt.client.ContactsServiceAsync;
import bwbv.rlt.client.event.AddContactEvent;
import bwbv.rlt.client.event.EditContactEvent;
import bwbv.rlt.domain.Detail;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;
import java.util.List;

public class ContactsPresenter implements Presenter {  

  private List<Detail> details;

  public interface Display {
    HasClickHandlers getAddButton();
    HasClickHandlers getDeleteButton();
    HasClickHandlers getList();
    void setData(List<String> data);
    int getClickedRow(ClickEvent event);
    List<Integer> getSelectedRows();
    Widget asWidget();
  }
  
  private final ContactsServiceAsync rpcService;
  private final HandlerManager eventBus;
  private final Display display;
  
  public ContactsPresenter(ContactsServiceAsync rpcService, HandlerManager eventBus, Display view) {
    this.rpcService = rpcService;
    this.eventBus = eventBus;
    this.display = view;
  }
  
  public void bind() {
    display.getAddButton().addClickHandler(new ClickHandler() {   
      public void onClick(ClickEvent event) {
        eventBus.fireEvent(new AddContactEvent());
      }
    });

    display.getDeleteButton().addClickHandler(new ClickHandler() {   
      public void onClick(ClickEvent event) {
        deleteSelectedContacts();
      }
    });
    
    display.getList().addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        int selectedRow = display.getClickedRow(event);
        
        if (selectedRow >= 0) {
          String id = details.get(selectedRow).getId();
          eventBus.fireEvent(new EditContactEvent(id));
        }
      }
    });
  }
  
  public void go(final HasWidgets container) {
    bind();
    container.clear();
    container.add(display.asWidget());
    fetchRltDetails();
//    fetchContactDetails();
  }

  public void sortContactDetails() {
    
    // Yes, we could use a more optimized method of sorting, but the 
    //  point is to create a test case that helps illustrate the higher
    //  level concepts used when creating MVP-based applications. 
    //
    for (int i = 0; i < details.size(); ++i) {
      for (int j = 0; j < details.size() - 1; ++j) {
        if (details.get(j).getDisplayName().compareToIgnoreCase(details.get(j + 1).getDisplayName()) >= 0) {
          Detail tmp = details.get(j);
          details.set(j, details.get(j + 1));
          details.set(j + 1, tmp);
        }
      }
    }
  }

  public void setContactDetails(List<Detail> contactDetails) {
    this.details = contactDetails;
  }
  
  public Detail getContactDetail(int index) {
    return details.get(index);
  }
  
  private void fetchContactDetails() {
    rpcService.getContactDetails(new AsyncCallback<ArrayList<Detail>>() {
      public void onSuccess(ArrayList<Detail> result) {
          details = result;
          sortContactDetails();
          List<String> data = new ArrayList<String>();

          for (int i = 0; i < result.size(); ++i) {
            data.add(details.get(i).getDisplayName());
          }
          
          display.setData(data);
      }
      
      public void onFailure(Throwable caught) {
        Window.alert("Error fetching contact details");
      }
    });
  }
  
  private void fetchRltDetails() {
	  rpcService.getRltDetails(new AsyncCallback<ArrayList<Detail>>() {
		  public void onSuccess(ArrayList<Detail> result) {
			  details = result;
			  List<String> data = new ArrayList<String>();
			  
			  for (int i = 0; i < result.size(); ++i) {
				  data.add(details.get(i).getDisplayName());
			  }
			  
			  display.setData(data);
		  }
		  
		  public void onFailure(Throwable caught) {
			  Window.alert("Error fetching contact details");
		  }
	  });
  }

  private void deleteSelectedContacts() {
    List<Integer> selectedRows = display.getSelectedRows();
    ArrayList<String> ids = new ArrayList<String>();
    
    for (int i = 0; i < selectedRows.size(); ++i) {
      ids.add(details.get(selectedRows.get(i)).getId());
    }
    
    rpcService.deleteContacts(ids, new AsyncCallback<ArrayList<Detail>>() {
      public void onSuccess(ArrayList<Detail> result) {
        details = result;
        sortContactDetails();
        List<String> data = new ArrayList<String>();

        for (int i = 0; i < result.size(); ++i) {
          data.add(details.get(i).getDisplayName());
        }
        
        display.setData(data);
        
      }
      
      public void onFailure(Throwable caught) {
        Window.alert("Error deleting selected contacts");
      }
    });
  }
}
