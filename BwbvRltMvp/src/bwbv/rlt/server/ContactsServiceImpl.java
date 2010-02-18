package bwbv.rlt.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import bwbv.rlt.client.ContactsService;
import bwbv.rlt.domain.Contact;
import bwbv.rlt.domain.Detail;
import bwbv.rlt.domain.Rlt;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class ContactsServiceImpl extends RemoteServiceServlet implements
    ContactsService {

	private ArrayList<Detail> rltDetailList;
	
  private static final String[] contactsFirstNameData = new String[] {
      "Hollie", "Emerson", "Healy", "Brigitte", "Elba", "Claudio",
      "Dena", "Christina", "Gail", "Orville", "Rae", "Mildred",
      "Candice", "Louise", "Emilio", "Geneva", "Heriberto", "Bulrush", 
      "Abigail", "Chad", "Terry", "Bell"};
  
  private final String[] contactsLastNameData = new String[] {
      "Voss", "Milton", "Colette", "Cobb", "Lockhart", "Engle",
      "Pacheco", "Blake", "Horton", "Daniel", "Childers", "Starnes",
      "Carson", "Kelchner", "Hutchinson", "Underwood", "Rush", "Bouchard", 
      "Louis", "Andrews", "English", "Snedden"};
  
  private final String[] contactsEmailData = new String[] {
      "mark@example.com", "hollie@example.com", "boticario@example.com",
      "emerson@example.com", "healy@example.com", "brigitte@example.com",
      "elba@example.com", "claudio@example.com", "dena@example.com",
      "brasilsp@example.com", "parker@example.com", "derbvktqsr@example.com",
      "qetlyxxogg@example.com", "antenas_sul@example.com",
      "cblake@example.com", "gailh@example.com", "orville@example.com",
      "post_master@example.com", "rchilders@example.com", "buster@example.com",
      "user31065@example.com", "ftsgeolbx@example.com"};
      
  private final HashMap<String, Contact> contacts = new HashMap<String, Contact>();

  public ContactsServiceImpl() {
    initContacts();
    initRltDetails();
  }
  
  private void initContacts() {
    // TODO: Create a real UID for each contact
    //
    for (int i = 0; i < contactsFirstNameData.length && i < contactsLastNameData.length && i < contactsEmailData.length; ++i) {
      Contact contact = new Contact(String.valueOf(i), contactsFirstNameData[i], contactsLastNameData[i], contactsEmailData[i]);
      contacts.put(contact.getId(), contact); 
    }
  }
  
  private void initRltDetails() {
	  rltDetailList = new ArrayList<Detail>();
	  rltDetailList.add(new Detail("1", "1. BezRlt NW"));
	  rltDetailList.add(new Detail("2", "2. BezRlt NW"));
	  rltDetailList.add(new Detail("3", "3. BezRlt NW"));
	  rltDetailList.add(new Detail("4", "4. BezRlt NW"));
  }
  
  public Contact addContact(Contact contact) {
    contact.setId(String.valueOf(contacts.size()));
    contacts.put(contact.getId(), contact); 
    return contact;
  }

  public Contact updateContact(Contact contact) {
    contacts.remove(contact.getId());
    contacts.put(contact.getId(), contact); 
    return contact;
  }

  public Boolean deleteContact(String id) {
    contacts.remove(id);
    return true;
  }
  
  public ArrayList<Detail> deleteContacts(ArrayList<String> ids) {

    for (int i = 0; i < ids.size(); ++i) {
      deleteContact(ids.get(i));
    }
    
    return getContactDetails();
  }
  
  public ArrayList<Detail> getContactDetails() {
    ArrayList<Detail> contactDetails = new ArrayList<Detail>();
    
    Iterator<String> it = contacts.keySet().iterator();
    while(it.hasNext()) { 
      Contact contact = contacts.get(it.next());          
      contactDetails.add(contact.getLightWeightContact());
    }
    
    return contactDetails;
  }

  public Contact getContact(String id) {
    return contacts.get(id);
  }
  
  public ArrayList<Detail> getRltDetails() {
	  return rltDetailList;
  }
  
	public Rlt getRlt(String id) {
		Rlt rlt = null;
		for (Detail detail : rltDetailList) {
			if (detail.getId().equals(id)) {
				rlt = new Rlt();
				rlt.setId(id);
				rlt.setKurzbez(detail.getDisplayName());
				break;
			}
		}
		return rlt;
	}

}
