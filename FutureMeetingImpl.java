import java.util.Calendar;
import java.util.Set;

/**
* A meeting to be held in the future
*
* 6th February 2013 - Created from the FutureMeeting interface
* Constructor added
*/
public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting
{

	/**
	*constructor - creates a new FutureMeeting
	* @param date the date (and time?) of the new meeting
	* @param contacts the list of participating contacts
	*/
	public FutureMeetingImpl(Set<Contact> contacts, Calendar date)
	{
		super(contacts, date);
	}

	// No methods here, this is just a naming interface
	// (i.e. only necessary for type checking and/or downcasting)
}
