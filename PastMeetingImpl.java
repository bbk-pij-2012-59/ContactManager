import java.util.Calendar;
import java.util.Set;

/**
* A meeting that was held in the past.
*
* It includes your notes about what happened and what was agreed.
*
* 6th February 2013 - Created from the Meeting interface
* One extra field, another constructor and interior of method added
* Probably will also need a setNotes method
* Compiles OK
*/

public class PastMeetingImpl extends MeetingImpl implements PastMeeting

{

	private String MeetingNotes;

	/**
	*constructor - creates a new PastMeeting
	* @param date the date (and time?) of the new meeting
	* @param contacts the list of participating contacts
	* @notes our notes, if any, about the meeting
	* For better security, could follow KLM's instructions,
	* define setDate, setContacts and setNotes methods for use in this constructor
	*/
	public PastMeetingImpl(Set<Contact> contacts, Calendar date, String notes)
	{
		super(contacts, date);
		this.MeetingNotes = notes;
	}

	/**
	* Returns the notes from the meeting.
	*
	* If there are no notes, the empty string is returned.
	*
	* @return the notes from the meeting.
	*/
	public String getNotes()
	{
			return this.MeetingNotes;
	}

}