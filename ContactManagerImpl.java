import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
* A class to manage your contacts and meetings.
* 6th February 2013 - Created from the ContactManager interface
* Empty constructor and methods
* 7th February 2013 - English language (not even pseudocode) descriptions of methods!
* 5th March 2013 - added dummy return statements, so that the compiler isn't screaming!
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
// If the date provided is in the future and all the contacts exist
// 		create a new instance of FutureMeetingImpl, passing its constructor the parameters provided
// otherwise throw the required exception (IllegalArgumentException)
return 10;//dummy value
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
// If the meeting ID exists
// 		If the date for the corresponding meeting is not in the future
// 			return the corresponding meeting
//		otherwise throw the required exception (IllegalArgumentException)
// otherwise return null
return null;//dummy value
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
// If the meeting ID exists
// 		If the date for the corresponding meeting is not in the past
// 			return the corresponding meeting
//		otherwise throw the required exception (IllegalArgumentException)
// otherwise return null
return null;//dummy value
	}


	/**
	* Returns the meeting with the requested ID, or null if it there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	*/
	public Meeting getMeeting(int id)
	{
// 	If the meeting ID exists
//		return the corresponding meeting
// otherwise return null
return null;//dummy value
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
// If the contact exists
//		If meetings are scheduled with the contact
//			return a sorted (by date and time) list of those meetings
//		otherwise return an empty list
// otherwise throw the required exception (IllegalArgumentException)
return null;//dummy value
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
// If there were or are to be any meetings scheduled on the date provided
//		return a sorted (by time) list of those meetings
// otherwise return an empty list
return null;//dummy value
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
// If the contact exists
//		If the contact has participated in meetings
//			return a sorted (by date and time) list of those meetings
//		otherwise return an empty list
// otherwise throw the required exception (IllegalArgumentException)
return null;//dummy value
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
// If all the parameters are not null
// 		If all the contacts exist
//			(doesn't care if date is in past or not?)
// 			create a new instance of PastMeetingImpl
// 		otherwise throw the required exception (IllegalArgumentException)
// otherwise throw the required exception (NullPointerException)
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
// If the text parameter is not null (could be an empty string, but rather pointless)
// 		If the meeting id exists
//			If the corresponding meeting is not scheduled for the future
//				add the text provided to the end of the notes field for the corresponding meeting
// 			otherwise throw the required exception (IllegalStateException)
// 		otherwise throw the required exception (IllegalArgumentException)
// otherwise throw the required exception (NullPointerException)
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
// If both the name and the notes are not null (but notes can be an empty string)
//		create a new instance of ContactImpl, passing its constructor the parameters provided
// otherwise throw the required exception (NullPointerException)
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
// If string parameter provided is not null (what about if it's an empty string?)
//		return a list of contacts that contain that string within their name field
// otherwise throw the required exception (NullPointerException)
return null;//dummy value
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


}
