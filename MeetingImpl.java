import java.util.Calendar;
import java.util.Set;

/**
* A class to represent meetings
*
* Meetings have unique IDs, scheduled date and a list of participating contacts
*
* 6th February 2013 - Created from the Meeting interface
* Three (plus one static) fields, constructor and interior of methods added
* Compiles OK
*/

public class MeetingImpl implements Meeting
{

	private int MeetingID;
	private Calendar MeetingDate;
	private Set<Contact> MeetingParticipants;
	private static int MeetingCount = 1000; //I like IDs to have the same number of digits...

	/**
	*constructor - creates a new meeting
	* @param date the date (and time?) of the new meeting
	* @param contacts the list of participating contacts
	* For better security, could follow KLM's instructions,
	* define setContacts and setDate methods for use in this constructor
	*/
	public MeetingImpl(Set<Contact> contacts, Calendar date)
	{
		this.MeetingDate = date;
		this.MeetingParticipants = contacts;
		MeetingCount++;
		this.MeetingID = MeetingCount;
	}

	/**
	* Returns the id of the meeting.
	*
	* @return the id of the meeting.
	*/

	public int getId()
	{
		return this.MeetingID;
	}

	/**
	* Return the date of the meeting.
	*
	* @return the date of the meeting.
	*/
	public Calendar getDate()
	{
		return this.MeetingDate;
	}

	/**
	* Return the details of people that attended the meeting.
	*
	* The list contains a minimum of one contact (if there were
	* just two people: the user and the contact) and may contain an
	* arbitrary number of them.
	*
	* @return the details of people that attended the meeting.
	*/
	public Set<Contact> getContacts()
	{
		return this.MeetingParticipants;
	}

}