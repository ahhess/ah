package bwbv.rlt.client;

import bwbv.rlt.domain.Contact;
import bwbv.rlt.domain.Detail;
import bwbv.rlt.domain.Rlt;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;

@RemoteServiceRelativePath("contactsService")
public interface ContactsService extends RemoteService {
	
  Contact addContact(Contact contact);
  Boolean deleteContact(String id); 
  ArrayList<Detail> deleteContacts(ArrayList<String> ids);
  ArrayList<Detail> getContactDetails();
  Contact getContact(String id);
  Contact updateContact(Contact contact);

  ArrayList<Detail> getRltDetails();
  Rlt getRlt(String id);
}
