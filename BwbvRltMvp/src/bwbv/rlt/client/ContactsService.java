package bwbv.rlt.client;

import bwbv.rlt.domain.Contact;
import bwbv.rlt.domain.ContactDetail;
import bwbv.rlt.model.domain.Rlt;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;

@RemoteServiceRelativePath("contactsService")
public interface ContactsService extends RemoteService {
	
  Contact addContact(Contact contact);
  Boolean deleteContact(String id); 
  ArrayList<ContactDetail> deleteContacts(ArrayList<String> ids);
  ArrayList<ContactDetail> getContactDetails();
  Contact getContact(String id);
  Contact updateContact(Contact contact);

  ArrayList<ContactDetail> getRltDetails();
  Rlt getRlt(int id);
}
