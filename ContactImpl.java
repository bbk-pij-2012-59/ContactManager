/**
* A contact is a person we are making business with or may do in the future.
*
* Contacts have an ID (unique), a name (probably unique, but maybe
* not), and notes that the user may want to save about them.
*
* 30th January 2013 - Created from the Contact interface
* Three (plus one static) fields, constructor and interior of methods added
* 31st January 2013 - Compiles OK and passes current set of four tests
*/

public class ContactImpl implements Contact
{

	private int ContactID;
	private String ContactName;
	private String ContactNotes;
	private static int ContactCount = 1000; //I like IDs to have the same number of digits...
	//Obviously, a real contact database would have far more fields than this!

	/**
	*constructor - creates a new contact
	* @param name the name of the new contact
	* @param notes our notes, if any, about the contact
	* For better security, could follow KLM's instructions,
	* define setID and setName methods for use in this constructor
	*/
	public ContactImpl(String name, String notes)
	{
		this.ContactName = name;
		this.ContactNotes = notes;
		ContactCount++;
		this.ContactID = ContactCount;
	}

	/**
	* Returns the ID of the contact.
	*
	* @return the ID of the contact.
	*/
	public int getId()
	{
		return this.ContactID;
	}

	/**
	* Returns the name of the contact.
	*
	* @return the name of the contact.
	*/
	public String getName()
	{
		return this.ContactName;
	}


	/**
	* Returns our notes about the contact, if any.
	*
	* If we have not written anything about the contact, the empty
	* string is returned.
	*
	* @return a string with notes about the contact, maybe empty.
	*/
	public String getNotes()
	{
		return this.ContactNotes;
	}

	/**
	* Add notes about the contact.
	*
	* @param note the notes to be added
	*/
	public void addNotes(String note)
	{
		this.ContactNotes = this.ContactNotes + note;
		//Could be kind to the user and add a space (or linebreak) between old notes and new notes...
	}
}
