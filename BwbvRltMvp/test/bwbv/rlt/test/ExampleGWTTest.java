package bwbv.rlt.test;

import bwbv.rlt.client.ContactsService;
import bwbv.rlt.client.ContactsServiceAsync;
import bwbv.rlt.client.presenter.ContactsPresenter;
import bwbv.rlt.client.view.ContactsView;
import bwbv.rlt.domain.Detail;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.junit.client.GWTTestCase;

import java.util.ArrayList;

public class ExampleGWTTest extends GWTTestCase {
  private ContactsPresenter contactsPresenter;
  private ContactsServiceAsync rpcService;
  private HandlerManager eventBus;
  private ContactsPresenter.Display display;
  
  public String getModuleName() {
    return "bwbv.rlt.Contacts";
  }
  
  public void gwtSetUp() {
    rpcService = GWT.create(ContactsService.class);
    eventBus = new HandlerManager(null);
    display = new ContactsView();
    contactsPresenter = new ContactsPresenter(rpcService, eventBus, display);
  }
  
  public void testContactSort(){
    ArrayList<Detail> contactDetails = new ArrayList<Detail>();
    contactDetails.add(new Detail("0", "c_contact"));
    contactDetails.add(new Detail("1", "b_contact"));
    contactDetails.add(new Detail("2", "a_contact"));
    contactsPresenter.setContactDetails(contactDetails);
    contactsPresenter.sortContactDetails();
    assertTrue(contactsPresenter.getContactDetail(0).getDisplayName().equals("a_contact"));
    assertTrue(contactsPresenter.getContactDetail(1).getDisplayName().equals("b_contact"));
    assertTrue(contactsPresenter.getContactDetail(2).getDisplayName().equals("c_contact"));
  }
}
