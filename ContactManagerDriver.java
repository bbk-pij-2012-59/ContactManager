import java.util.Calendar;
import java.util.Set;
import java.util.HashSet;

/**
* 5th March 2013 - Created so that I can get a feel for the system
* 5th March 2013 - ContactImpl instances created
* 5th March 2013 - Calendar instance created
* 5th March 2013 - HashSet of Contacts created
*/

class ContactManagerDriver
{

	public static void main(String[] args)
	{
		ContactManagerDriver cmd1 = new ContactManagerDriver();
		cmd1.launch();
	}

	public void launch()
	{
		//ContactManager cmd1 = new ContactManagerImpl();
		//System.out.println(cmd1);
		//System.out.println(cmd1.AllMeetings);
		//System.out.println(cmd1.AllContacts);

		Contact c1 = new ContactImpl ("First Contact", "Notes on first contact");
		Contact c2 = new ContactImpl ("Second Contact", "");
		System.out.println(c1);
		System.out.println(c1.getId());
		System.out.println(c1.getName());
		System.out.println(c1.getNotes());
		System.out.println(c2);
		System.out.println(c2.getId());
		System.out.println(c2.getName());
		System.out.println(c2.getNotes());

		c1.addNotes("More notes for first contact");
		c2.addNotes("Notes about second contact");
		System.out.println(c1.getNotes());
		System.out.println(c2.getNotes());

		Calendar cal1 = Calendar.getInstance();
		System.out.println(cal1);

		Set<Contact> setc1 = new HashSet<Contact>();
		System.out.println(setc1);
		setc1.add(c1);
		setc1.add(c2);
		for (Contact next : setc1)
		{
		
			System.out.println(next.getId() + " " + next.getName() + " " + next.getNotes() + " ");
		}
	}

}