import java.util.Calendar;
import java.util.List;
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

*/
public class ContactManagerImpl implements ContactManager
{

	private List<Meeting> AllMeetings;
	private Set<Contact> AllContacts;

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
	public int addFutureMeeting(Set<Contact> contacts, Calendar date) throws IllegalArgumentException
	{
		if(dateIsBeforeNow(date) || !contactExists(contacts))
		{
			throw new IllegalArgumentException("Trying to add future meeting: contact doesn't exist or date is in past");
		}
		else
		{
			FutureMeeting fmx = new FutureMeetingImpl(contacts, date);
		}
		return fmx.getId();
	}


	/**
	* Returns the PAST meeting with the requested ID, or null if it there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	* @throws IllegalArgumentException if there is a meeting with that ID happening in the future
	*/
	public PastMeeting getPastMeeting(int id) throws IllegalArgumentException
	{
		PastMeeting pmx = getMeeting(id);
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
	public FutureMeeting getFutureMeeting(int id) throws IllegalArgumentException
	{
		FutureMeeting fmx = getMeeting(id);
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
	public Meeting getMeeting(int id)
	{
		for (Meeting next : AllMeetings)
		{
		
			if (id = next.id())
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
	public List<Meeting> getFutureMeetingList(Contact contact) throws IllegalArgumentException
	{
		if(!contactExists(contact))
		{
			throw new IllegalArgumentException("Trying to find future meetings with contact: contact does not exist");
		}
		else
		{	
		List<Meeting> listfmx = new ArrayList<Meeting>();
//		If meetings are scheduled with the contact
//			add meetings into list
		}
//		sort list by date and time
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
//		}
//		sort list by date and time
		return listmx;
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
	public List<PastMeeting> getPastMeetingList(Contact contact) throws IllegalArgumentException
	{
		if(!contactExists(contact))
		{
			throw new IllegalArgumentException("Trying to find past meetings with contact: contact does not exist");
		}
		else
		{	
		List<Meeting> listpmx = new ArrayList<Meeting>();
//		If meetings happened with the contact
//			add meetings into list
		}
//		sort list by date and time
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
	public void addMeetingNotes(int id, String text) throws NullPointerException, IllegalStateException, IllegalArgumentException
	{
		if (notes = null)
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
			PastMeeting pmx = new PastMeetingImpl(fmx, txt);
		}
	}


	/**
	* Create a new contact with the specified name and notes.
	*
	* @param name the name of the contact.
	* @param notes notes to be added about the contact.
	* @throws NullPointerException if the name or the notes are null
	*/
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
	public Set<Contact> getContacts(int... ids) throws IllegalArgumentException
	{

// If all the contact IDs exist
//		return a list of the corresponding contacts
// otherwise throw the required exception (IllegalArgumentException)
return null;//dummy value
	}


	/**
	* Returns a list with the contacts whose name contains that string.
	*
	* @param name the string to search for
	* @return a list with the contacts whose name contains that string.
	* @throws NullPointerException if the parameter is null
	*/
	public Set<Contact> getContacts(String name) throws NullPointerException
	{
		if(name == null)
		{
			throw new NullPointerException("Searching for contacts: search string is null");
		}
		else
		{
			Set<Contact> setcx = new HashSet<Contact>();
			for (Contact next : AllContacts)
			{
				nextName = next.getName();
				nameLength = nextName.length();
				boolean includesString = true;
				for(int i = 0; i < nameLength; i++)
				{
					//check to see if string is in name
					//if not, change includesString to false;
				}
				if(includesString)
				{
					setcx.add(next);
				}
			}
		return setcx;
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
		boolean result = true;
		//check whether date is actually after now
		//if so, change result to false
		return result;
	}

	/**
	* Checks whether a contact exists
	*
	* @param contact the contact to be checked	*
	* @return true if the contact exists, false otherwise
	*/
	private boolean contactExists(Contact contact)
	{
		boolean result = true;
		//check whether contact actually exists
		//if not, change result to false
		return result;
	}

	/**
	* Checks whether a set of contacts exists
	*
	* @param contact the set of contacts to be checked	*
	* @return true if all the contact exist, false otherwise
	*/
	private boolean contactExists(Set<Contact> contact)
	{
		boolean result = true;
		//check whether all contacts actually exist, by calling contactExists for each contact
		//if not, change result to false
		return result;
	}

	/**
	* Checks whether a meeting exists
	*
	* @param meetingID the ID of the meeting to be checked
	* @return true if the meeting exists, false otherwise
	*/
	private boolean meetingExists(int meetingID)
	{
		boolean result = true;
		//check whether meeting actually exists
		//if not, change result to false
		return result;
	}


	/**
	* Finds the date of a meeting from its ID
	*
	* @param meetingID the ID of the meeting
	* @return the date of the meeting
	*/
	private Calendar findDateFromMeetingID(int meetingID)
	{
		Calendar dateOfMeeting = ; //need to find this
		return dateOfMeeting;
	}

}
