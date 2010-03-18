package bwbv.rlt.client;

import bwbv.rlt.domain.Contact;
import bwbv.rlt.domain.ContactDetail;
import bwbv.rlt.model.domain.Rlt;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;


public interface ContactsServiceAsync {

  public void addContact(Contact contact, AsyncCallback<Contact> callback);
  public void deleteContact(String id, AsyncCallback<Boolean> callback);
  public void deleteContacts(ArrayList<String> ids, AsyncCallback<ArrayList<ContactDetail>> callback);
  public void getContactDetails(AsyncCallback<ArrayList<ContactDetail>> callback);
  public void getContact(String id, AsyncCallback<Contact> callback);
  public void updateContact(Contact contact, AsyncCallback<Contact> callback);

  void getRltDetails(AsyncCallback<ArrayList<ContactDetail>> callback);
  void getRlt(int id, AsyncCallback<Rlt> callback);
}

