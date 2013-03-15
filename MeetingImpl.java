import java.util.Calendar;
import java.util.Set;
import java.io.Serializable;

/**
* A class to represent meetings
*
* Meetings have unique IDs, scheduled date and a list of participating contacts
*
* 6th February 2013 - Created from the Meeting interface
* Three (plus one static) fields, constructor and interior of methods added
* 28th February 2013 - further constructor added
* 12th March 2013 - implements Comparable and has CompareTo method for sorting by date
* 14th March 2013 - overriding toString method, but not equals and HashCode
*/

public class MeetingImpl implements Comparable, Meeting, Serializable
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
	*constructor - used when converting between a FutureMeetingImpl and a PastMeetingImpl
	* @param id the id of the original meeting
	* @param date the date (and time?) of the new meeting
	* @param contacts the list of participating contacts
	* For better security, could follow KLM's instructions,
	* define setContacts and setDate methods for use in this constructor
	*/
	public MeetingImpl(int oldId, Set<Contact> contacts, Calendar date)
	{
		this.MeetingID = oldId;
		this.MeetingDate = date;
		this.MeetingParticipants = contacts;
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

	/**
	* Used for sorting by date
	*
	* @return an integer
	*/
	public int compareTo(Object otherObject)
	{
		Meeting other = (Meeting) otherObject;
		int n = 0;
		if (this.MeetingDate.after(other.getDate()))
		{
			n = 1;
		}
		else if (this.MeetingDate.before(other.getDate()))
		{
			n = -1;
		}
		return n;
	}

	/**
	* toString method to override that from Object class
	* @return String consisting of meeting's ID, date and notes
	*
	*/
	public String toString()
	{
		String meetingAsString = "Meeting: " + this.getId() + " on " + this.getDate().getTime();
		return meetingAsString;
	}

}


