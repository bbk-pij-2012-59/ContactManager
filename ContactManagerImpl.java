import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.io.Serializable;
import java.util.Set;


/**
* A class to manage your contacts and meetings.
* 6th February 2013 - Created from the ContactManager interface
* Empty constructor and methods
* 7th February 2013 - English language (not even pseudocode) descriptions of methods!
* 5th March 2013 - added dummy return statements, so that the compiler isn't screaming!
* 5th March 2013 - created some private methods to do some of the checking for conditions that cause exceptions to be thrown
*                  (won't need to write these methods until later!)
* 6th March 2013 - continuing with methods, both public and private
* 7th March 2013 - throwing exceptions
* 8th March 2013 - every exception is to be thrown within an if statement
* 11th March 2013 - testing individual methods using launch2 method of ContactManagerDriver
*                   addFutureMeeting(Set<Contact> contacts, Calendar date) generates an ID
*		    getMeeting(int id) appears to work
*		    addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) appears to work
*		    getFutureMeeting(int id) appears to work
*		    getPastMeeting(int id) appears to work
* 12th March 2013 - continuing to write methods
*		    getAllMeetingList compiles
*		    getPastMeetingList compiles
*		    getFutureMeetingList compiles
*		    both versions of contactExists compile
*		    addNewContact compiles
*		    getContacts(int... ids) compiles
* 13th March 2013 - continuing to write methods
*		    getContacts(String name) compiles
* 14th March 2013 - dateIsBeforeNow method
*/
public class ContactManagerImpl implements ContactManager, Serializable
{

	//private List<Meeting> AllMeetings;
	//private Set<Contact> AllContacts;
	public List<Meeting> AllMeetings; //should make it easier to test what's going on
	public Set<Contact> AllContacts; //should it easier to test what's going on

	/**
	*constructor - creates a new ContactManager
	*/
	public ContactManagerImpl()
	{
		AllContacts = new HashSet<Contact>();
		AllMeetings = new ArrayList<Meeting>();
	}

	/**
	* Add a new meeting to be held in the future.
	*
	* @param contacts a list of contacts that will participate in the meeting
	* @param date the date on which the meeting will take place
	* @return the ID for the meeting
	* @throws IllegalArgumentException if the meeting is set for a time in the past,
	* of if any contact is unknown / non-existent
	*/
//APPEARS TO WORK 11/03/2013
	public int addFutureMeeting(Set<Contact> contacts, Calendar date) throws IllegalArgumentException
	{
		if(dateIsBeforeNow(date) || !contactExists(contacts))
		{
			throw new IllegalArgumentException("Trying to add future meeting: contact doesn't exist or date is in past");
		}
		else
		{
			FutureMeeting fmx = new FutureMeetingImpl(contacts, date);
			AllMeetings.add(fmx);
			return fmx.getId();
		}
	}


	/**
	* Returns the PAST meeting with the requested ID, or null if it there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	* @throws IllegalArgumentException if there is a meeting with that ID happening in the future
	*/
//APPEARS TO WORK 11/03/2013
	public PastMeeting getPastMeeting(int id) throws IllegalArgumentException
	{
		PastMeeting pmx = (PastMeeting)getMeeting(id);
		if(!dateIsBeforeNow(pmx.getDate()))
		{
			throw new IllegalArgumentException("Trying to find past meeting: meeting with that ID is in the future");
		}
			return pmx;
	}


	/**
	* Returns the FUTURE meeting with the requested ID, or null if there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	* @throws IllegalArgumentException if there is a meeting with that ID happening in the past
	*/
//APPEARS TO WORK 11/03/2013
	public FutureMeeting getFutureMeeting(int id) throws IllegalArgumentException
	{
		FutureMeeting fmx = (FutureMeeting)getMeeting(id);
		if(dateIsBeforeNow(fmx.getDate()))
		{
			throw new IllegalArgumentException("Trying to find future meeting: meeting with that ID is in the past");
		}
		return fmx;
	}


	/**
	* Returns the meeting with the requested ID, or null if it there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	*/
//APPEARS TO WORK 11/03/2013
	public Meeting getMeeting(int id)
	{
		for (Meeting next : AllMeetings)
		{
		
			if (id == next.getId())
			{
				return next;
			}
		}
		return null;
	}


	/**
	* Returns the list of future meetings scheduled with this contact.
	*
	* If there are none, the returned list will be empty. Otherwise,
	* the list will be chronologically sorted and will not contain any
	* duplicates.
	*
	* @param contact one of the user’s contacts
	* @return the list of future meeting(s) scheduled with this contact (maybe empty).
	* @throws IllegalArgumentException if the contact does not exist
	*/
//COMPILES 12/03/2012, BUT SORT NOT IMPLEMENTED
	public List<Meeting> getFutureMeetingList(Contact contact) throws IllegalArgumentException
	{
		List<Meeting> listfmx = new ArrayList<Meeting>();
		List<Meeting> listmx = getAllMeetingList(contact);
		if(!listmx.isEmpty())
		{
			Calendar now = Calendar.getInstance();
			for(Meeting next: listmx)//step through the list of meetings with this contact
			{
				Calendar nextclr = next.getDate();//date for this meeting
				if(nextclr.after(now))//check to see if date is in future
				{
					listfmx.add(next);//if so, add this meeting to listpmx
				}
			}
//			Collections.sort(listfmx);
		}
		return listfmx;
	}


	/**
	* Returns the list of meetings that are scheduled for, or that took
	* place on, the specified date
	*
	* If there are none, the returned list will be empty. Otherwise,
	* the list will be chronologically sorted and will not contain any
	* duplicates.
	*
	* @param date the date
	* @return the list of meetings
	*/
	public List<Meeting> getFutureMeetingList(Calendar date)
	{
		List<Meeting> listmx = new ArrayList<Meeting>();
//		If meetings happened on or are scheduled for that date
//		{
//			add meetings into list
//			listmx = Collections.sort(listmx);
			return listmx;
//		}
	}


	/**
	* Returns the list of past meetings in which this contact has participated.
	*
	* If there are none, the returned list will be empty. Otherwise,
	* the list will be chronologically sorted and will not contain any
	* duplicates.
	*
	* @param contact one of the user’s contacts
	* @return the list of PAST meeting(s) scheduled with this contact (maybe empty).
	* @throws IllegalArgumentException if the contact does not exist
	*/
//COMPILES 12/03/2012, BUT SORT NOT IMPLEMENTED
	public List<PastMeeting> getPastMeetingList(Contact contact) throws IllegalArgumentException
	{
		List<PastMeeting> listpmx = new ArrayList<PastMeeting>();
		List<Meeting> listmx = getAllMeetingList(contact);
		if(!listmx.isEmpty())
		{
			Calendar now = Calendar.getInstance();
			for(Meeting next: listmx)//step through the list of meetings with this contact
			{
				Calendar nextclr = next.getDate();//date for this meeting
				if(nextclr.before(now))//check to see if date is in past
				{
					listpmx.add((PastMeeting)next);//if so, add this meeting to listpmx
				}
			}
//			listpmx = Collections.sort(listpmx);
		}
		return listpmx;
	}


	/**
	* Create a new record for a meeting that took place in the past.
	*
	* @param contacts a list of participants
	* @param date the date on which the meeting took place
	* @param text messages to be added about the meeting.
	* @throws IllegalArgumentException if the list of contacts is
	* empty, or any of the contacts does not exist
	* @throws NullPointerException if any of the arguments is null
	*/
//APPEARS TO WORK 11/03/2013
//NB Doesn't check whether date is in the past
	public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) throws NullPointerException
	{
		if(contacts == null || date == null || text == null)
		{
			throw new NullPointerException("Trying to create new past meeting: one of arguments is null");
		}
		else if(!contactExists(contacts))
		{
			throw new IllegalArgumentException("Trying to create new past meeting: at least one of contacts doesn't exist");
		}
		else
		{
			PastMeeting pmx = new PastMeetingImpl(contacts, date, text);
			AllMeetings.add(pmx);
		}
	}


	/**
	* Add notes to a meeting.
	*
	* This method is used when a future meeting takes place, and is
	* then converted to a past meeting (with notes).
	*
	* It can be also used to add notes to a past meeting at a later date.
	*
	* @param id the ID of the meeting
	* @param text messages to be added about the meeting.
	* @throws IllegalArgumentException if the meeting does not exist
	* @throws IllegalStateException if the meeting is set for a date in the future
	* @throws NullPointerException if the notes are null
	*/
//COMPILES 12/03/2012
	public void addMeetingNotes(int id, String text) throws NullPointerException, IllegalStateException, IllegalArgumentException
	{
		if (text == null)
		{
			throw new NullPointerException("Trying to add notes to meeting: notes are null");
		}
		else
		{
			Meeting fmx = getMeeting(id);
			if (fmx == null)
			{
				throw new IllegalArgumentException("Trying to add notes to meeting: meeting does not exist");
			}
			if(!dateIsBeforeNow(fmx.getDate()))
			{
				throw new IllegalStateException("Trying to add notes to meeting: meeting with that ID is in the future");
			}
			PastMeeting pmx = new PastMeetingImpl((FutureMeeting)fmx, text);
		}
	}


	/**
	* Create a new contact with the specified name and notes.
	*
	* @param name the name of the contact.
	* @param notes notes to be added about the contact.
	* @throws NullPointerException if the name or the notes are null
	*/
//COMPILES 12/03/2012
	public void addNewContact(String name, String notes) throws NullPointerException
	{
		if(name == null || notes ==null)
		{
			throw new NullPointerException("Trying to create new contact: name or notes null");
		}
		else
		{
			Contact cx = new ContactImpl(name, notes);
			AllContacts.add(cx);
		}
	}


	/**
	* Returns a list containing the contacts that correspond to the IDs.
	*
	* @param ids an arbitrary number of contact IDs
	* @return a list containing the contacts that correspond to the IDs.
	* @throws IllegalArgumentException if any of the IDs does not correspond to a real contact
	*/
//COMPILES 12/03/2012
	public Set<Contact> getContacts(int... ids) throws IllegalArgumentException
	{
		Set<Contact> setcx = new HashSet<Contact>();
		int countProvided = ids.length;
		int countFound = 0;
		for(int i = 0; i < countProvided; i++)
		{
			for (Contact next : AllContacts)
			{
				if(next.getId() == ids[i])
				{
					setcx.add(next);
					countFound++;
				}
			}
		}
		if (countFound != countProvided)
		{
			throw new IllegalArgumentException("Trying to list of contacts corresponding to IDs: at least one contact does not exist");
		}
		else
		{
			return setcx; 			
		}
	}


	/**
	* Returns a list with the contacts whose name contains that string.
	*
	* @param name the string to search for
	* @return a list with the contacts whose name contains that string.
	* @throws NullPointerException if the parameter is null
	*/
//COMPILES 13/03/2012
	public Set<Contact> getContacts(String name) throws NullPointerException
	{
		if(name == null)
		{
			throw new NullPointerException("Searching for contacts: search string is null");
		}
		else
		{
			Set<Contact> setOfMatchingContacts = new HashSet<Contact>();
			int searchStringLength = name.length();
			for (Contact next : AllContacts)
			{
				int contactNameLength = next.getName().length();
				for(int i = 0; i < (contactNameLength - searchStringLength); i++)
				{
					boolean includesSearchString = true;
					for(int j = 0; j < searchStringLength; j++)
					{
						if(name.charAt(j) != next.getName().charAt(i+j))
						{
							 includesSearchString = false;
						}
					}
					if(includesSearchString)
					{
						setOfMatchingContacts.add(next);
					}
				}
			}
		return setOfMatchingContacts;
		}
	}

	/**
	* Save all data to disk.
	*
	* This method must be executed when the program is
	* closed and when/if the user requests it.
	*/
	public void flush()
	{
// Need to look up XMLWriter
	}

	
	/**
	* Checks whether a date is after or before (true) the current date
	*
	* @param date the date to be checked	*
	* @return false if the date is after, or true if the date is before, now
	*/
	private boolean dateIsBeforeNow(Calendar date)
	{
		boolean beforeNow = true;
		Calendar now = Calendar.getInstance();
		if(now.before(date))
		{
			beforeNow = false;
		}
		return beforeNow;
	}

	/**
	* Checks whether a contact exists
	*
	* @param contact the contact to be checked	*
	* @return true if the contact exists, false otherwise
	*/
//COMPILES 12/03/2012
	private boolean contactExists(Contact contact)
	{
		boolean contactIsInAllContacts = false;
		if(AllContacts.contains(contact))
		{
			contactIsInAllContacts = true;
		}
		return contactIsInAllContacts;
	}

	/**
	* Checks whether a set of contacts exists
	*
	* @param contact the set of contacts to be checked	*
	* @return true if all the contact exist, false otherwise
	*/
//COMPILES 12/03/2012
	private boolean contactExists(Set<Contact> contact)
	{
		boolean contactsAreInAllContacts = true;
		for (Contact next : contact)
		{
			contactsAreInAllContacts = contactsAreInAllContacts && contactExists(next);
		}
		return contactsAreInAllContacts;
	}


	/**
	* Returns the list of all meetings, both past and future, with this contact.
	*
	* If there are none, the returned list will be empty.
	*
	* @param contact one of the user’s contacts
	* @return the list of meeting(s) with this contact (may be empty).
	* @throws IllegalArgumentException if the contact does not exist
	*/
//COMPILES 12/03/2012
	private List<Meeting> getAllMeetingList(Contact contact) throws IllegalArgumentException
	{
		if(!contactExists(contact))
		{
			throw new IllegalArgumentException("Trying to find meetings with contact: contact does not exist");
		}
		else
		{	
			List<Meeting> listOfMeetingsWithThisContact = new ArrayList<Meeting>();
			for(Meeting next: AllMeetings)//step through the list of meetings
			{
				Set<Contact> nextclx = next.getContacts();//set of contacts for this meeting
				if(nextclx.contains(contact))//check to see if contact is in this set
				{
 					listOfMeetingsWithThisContact.add(next);//if so, add this meeting to listmx
				}
			}
			return listOfMeetingsWithThisContact;
		}
	}

}
