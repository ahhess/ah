package bwbv.rlt.test;

import bwbv.rlt.client.ContactsServiceAsync;
import bwbv.rlt.client.presenter.ContactsPresenter;
import bwbv.rlt.domain.Detail;

import com.google.gwt.event.shared.HandlerManager;

import java.util.ArrayList;
import junit.framework.TestCase;

import static org.easymock.EasyMock.createStrictMock;

public class ExampleJRETest extends TestCase {
  private ContactsPresenter contactsPresenter;
  private ContactsServiceAsync mockRpcService;
  private HandlerManager eventBus;
  private ContactsPresenter.Display mockDisplay;
  
  protected void setUp() {
    mockRpcService = createStrictMock(ContactsServiceAsync.class);
    eventBus = new HandlerManager(null);
    mockDisplay = createStrictMock(ContactsPresenter.Display.class);
    contactsPresenter = new ContactsPresenter(mockRpcService, eventBus, mockDisplay);
  }
  
  public void testContactSort() {
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