/**
* 5th March 2013 - Created so that I can get a feel for the system
* 5th March 2013 - ContactImpls created and printed
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
	}

}