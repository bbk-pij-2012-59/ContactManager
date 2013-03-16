import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
* 5th March 2013 - Created so that I can get a feel for the system
* 5th March 2013 - ContactImpl instances created
* 5th March 2013 - Calendar instance created
* 5th March 2013 - HashSet of Contacts created
* 5th March 2013 - Meeting instances created
* 11th March 2013 - Testing individual methods from ContactManagerImpl
*/

class ContactManagerDriver
{

	public static void main(String[] args)
	{
		ContactManagerDriver cmd1 = new ContactManagerDriver();
		cmd1.launch3();
	}

	public void launch()
	{
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

		Meeting m1 = new MeetingImpl(setc1, cal1);
		System.out.println("Meeting details: " + m1);
		System.out.println("Meeting number: " + m1.getId());
		System.out.println("Meeting date: " + m1.getDate().getTime());
		System.out.println("Meeting participants: " + m1.getContacts());

		FutureMeeting m2 = new FutureMeetingImpl(setc1, cal1);
		System.out.println("Meeting details: " + m2);
		System.out.println("Meeting number: " + m2.getId());
		System.out.println("Meeting date: " + m2.getDate().getTime());
		System.out.println("Meeting participants: " + m2.getContacts());

		PastMeeting m3 = new PastMeetingImpl(setc1, cal1, "Notes about third meeting");
		System.out.println("Meeting details: " + m3);
		System.out.println("Meeting number: " + m3.getId());
		System.out.println("Meeting date: " + m3.getDate().getTime());
		System.out.println("Meeting participants: " + m3.getContacts());
		System.out.println("Meeting notes: " + m3.getNotes());

		PastMeeting m4 = new PastMeetingImpl((FutureMeetingImpl) m2, "Notes about fourth meeting");
		System.out.println("Meeting details: " + m4);
		System.out.println("Meeting number: " + m4.getId());
		System.out.println("Meeting date: " + m4.getDate().getTime());
		System.out.println("Meeting participants: " + m4.getContacts());
		System.out.println("Meeting notes: " + m4.getNotes());

	}

	public void launch2()
	{
		ContactManager cm1 = new ContactManagerImpl();
		System.out.println(cm1);
		//System.out.println(cm1.AllMeetings);
		//System.out.println(cm1.AllContacts);

		System.out.println("");
		System.out.println("TESTING addNewContact(String name, String notes)");
		cm1.addNewContact("Fifth Contact", "Notes on fifth contact");

		System.out.println("");
		System.out.println("TESTING addFutureMeeting(Set<Contact> contacts, Calendar date)");
		Calendar cal2 = Calendar.getInstance();
		Contact c3 = new ContactImpl ("Third Contact", "Notes on third contact");
		Contact c4 = new ContactImpl ("Fourth Contact", "Notes on fourth contact");
		Set<Contact> setc2 = new HashSet<Contact>();
		setc2.add(c3);
		setc2.add(c4);
		int fmn1 = cm1.addFutureMeeting(setc2, cal2);
		System.out.println(fmn1);
		int fmn2 = cm1.addFutureMeeting(setc2, cal2);
		System.out.println(fmn2);

		System.out.println("");
		System.out.println("TESTING addNewPastMeeting(Set<Contact> contacts, Calendar date, String text)");
		cm1.addNewPastMeeting(setc2, cal2, "Notes for new past meeting");
		Meeting mx3 = cm1.getMeeting(1003);
		System.out.println("Meeting number: " + mx3.getId());
		System.out.println("Meeting date: " + mx3.getDate().getTime());
		System.out.println("Meeting participants: " + mx3.getContacts());

		System.out.println("");
		System.out.println("TESTING getMeeting(int id)");
		Meeting mx1 = cm1.getMeeting(1001);
		Meeting mx2 = cm1.getMeeting(1002);
		System.out.println("Meeting number: " + mx1.getId());
		System.out.println("Meeting date: " + mx1.getDate().getTime());
		System.out.println("Meeting participants: " + mx1.getContacts());
		System.out.println("Meeting number: " + mx2.getId());
		System.out.println("Meeting date: " + mx2.getDate().getTime());
		System.out.println("Meeting participants: " + mx2.getContacts());

		System.out.println("");
		System.out.println("TESTING getFutureMeeting(int id)");
		FutureMeeting fmx1 = cm1.getFutureMeeting(1002);
		System.out.println("Meeting number: " + fmx1.getId());
		System.out.println("Meeting date: " + fmx1.getDate().getTime());
		System.out.println("Meeting participants: " + fmx1.getContacts());


		System.out.println("");
		System.out.println("TESTING getPastMeeting(int id)");
		PastMeeting pmx1 = cm1.getPastMeeting(1003);
		System.out.println("Meeting number: " + pmx1.getId());
		System.out.println("Meeting date: " + pmx1.getDate().getTime());
		System.out.println("Meeting participants: " + pmx1.getContacts());

	}

	public void launch3()
	{
		System.out.println("CREATING new ContactManager object");
		ContactManager cm1 = new ContactManagerImpl();
		String x = null;

		System.out.println("");
		System.out.println("TESTING addNewContact(String name, String notes)");
		cm1.addNewContact("First Contact", "Notes on first contact");
		cm1.addNewContact("Second Contact", "Notes on second contact");
		cm1.addNewContact("Third Contact", "Notes on third contact");
		cm1.addNewContact("Fourth Contact", "Notes on fourth contact");
		cm1.addNewContact("Fifth Contact", "Notes on fifth contact");
		
		System.out.println("");
		System.out.println("TESTING getContacts(int... ids)");
		Set<Contact> setc1 = new HashSet<Contact>();
		Set<Contact> setc2 = new HashSet<Contact>();
		setc1 = cm1.getContacts(1001,1002,1003);
		System.out.println(setc1);
		setc2 = cm1.getContacts(1003,1004,1005);
		System.out.println(setc2);

		System.out.println("");
		System.out.println("TESTING getContacts(String name)");
		Set<Contact> setc3 = new HashSet<Contact>();
		setc3 = cm1.getContacts("fi");
		System.out.println(setc3);

		System.out.println("");
		System.out.println("TESTING addFutureMeeting(Set<Contact> contacts, Calendar date)");
		Calendar cal1 = Calendar.getInstance();
		System.out.println(cal1.getTime());
		cal1.set(2013,11,11);
		System.out.println(cal1.getTime());
		Calendar cal2 = Calendar.getInstance();
		System.out.println(cal2.getTime());
		cal2.set(2013,4,30,12,5);
		System.out.println(cal2.getTime());
		Calendar cal5 = Calendar.getInstance();
		System.out.println(cal5.getTime());
		cal5.set(2013,6,6);
		System.out.println(cal5.getTime());
		int fmn1 = cm1.addFutureMeeting(setc1, cal1);
		System.out.println(fmn1);
		int fmn2 = cm1.addFutureMeeting(setc2, cal2);
		System.out.println(fmn2);
		int fmn3 = cm1.addFutureMeeting(setc3, cal5);
		System.out.println(fmn3);

		System.out.println("");
		System.out.println("TESTING addNewPastMeeting(Set<Contact> contacts, Calendar date, String text)");
		Calendar cal3 = Calendar.getInstance();
		System.out.println(cal3.getTime());
		cal3.set(2012,11,11);
		System.out.println(cal3.getTime());
		Calendar cal4 = Calendar.getInstance();
		System.out.println(cal4.getTime());
		cal4.set(2012,4,3,2,1);
		System.out.println(cal4.getTime());
		Calendar cal6 = Calendar.getInstance();
		System.out.println(cal6.getTime());
		cal6.set(2012,4,3,1,2);
		System.out.println(cal6.getTime());
		cm1.addNewPastMeeting(setc1, cal3, "Notes about this past meeting");
		cm1.addNewPastMeeting(setc2, cal4, "Notes about that past meeting");
		cm1.addNewPastMeeting(setc3, cal6, "Notes about another past meeting");

		System.out.println("");
		System.out.println("TESTING getMeeting(int id)");
		Meeting mx1 = cm1.getMeeting(1002);
		System.out.println("Meeting number: " + mx1.getId());
		System.out.println("Meeting date: " + mx1.getDate().getTime());
		System.out.println("Meeting participants: " + mx1.getContacts());
		Meeting mx2 = cm1.getMeeting(1005);
		System.out.println(mx2);

		System.out.println("");
		System.out.println("TESTING getFutureMeeting(int id)");
		FutureMeeting fmx1 = cm1.getFutureMeeting(1001);
		System.out.println("Meeting number: " + fmx1.getId());
		System.out.println("Meeting date: " + fmx1.getDate().getTime());
		System.out.println("Meeting participants: " + fmx1.getContacts());
		FutureMeeting fmx2 = cm1.getFutureMeeting(1010);
		System.out.println(fmx2);


		System.out.println("");
		System.out.println("TESTING getPastMeeting(int id)");
		PastMeeting pmx1 = cm1.getPastMeeting(1004);
		System.out.println("Meeting number: " + pmx1.getId());
		System.out.println("Meeting date: " + pmx1.getDate().getTime());
		System.out.println("Meeting participants: " + pmx1.getContacts());
		PastMeeting pmx2 = cm1.getPastMeeting(999);
		System.out.println(pmx2);

		System.out.println("");
		System.out.println("TESTING getFutureMeetingList(Contact contact)");
		Set<Contact> setc4 = new HashSet<Contact>();
		setc4 = cm1.getContacts("co");
		for (Contact next : setc4)
		{
			System.out.println("The following future meetings are scheduled with "
				 + next + ": " + cm1.getFutureMeetingList(next));
		}

		System.out.println("");
		System.out.println("TESTING getPastMeetingList(Contact contact)");
		for (Contact next : setc4)
		{
			System.out.println("The following future meetings are scheduled with "
				 + next + ": " + cm1.getPastMeetingList(next));
		}

		System.out.println("");
		System.out.println("TESTING getFutureMeetingList(Calendar date)");
		System.out.println("Meetings on that date" + ": " + cm1.getFutureMeetingList(cal1));
		System.out.println("Meetings on that date" + ": " + cm1.getFutureMeetingList(cal6));
	}

/**
	public void launch4()
	{
		System.out.println("TESTING private methods of ContactManagerImpl");		
		System.out.println("CREATING new ContactManagerImpl object");
		ContactManagerImpl cm1 = new ContactManagerImpl();

		System.out.println("");
		System.out.println("TESTING dateIsBeforeNow(Calendar date)");
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2013,11,11);
		System.out.println("First time: " + cal1.getTime());
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2012,11,11);
		System.out.println("Second time: " + cal2.getTime());
		boolean b1 = cm1.dateIsBeforeNow(cal1);
		System.out.println("First time is before now is " + b1);
		boolean b2 = cm1.dateIsBeforeNow(cal2);
		System.out.println("Second time is before now is " + b2);

		System.out.println("");
		System.out.println("TESTING contactExists(Contact contact)");
		Contact c1 = new ContactImpl ("Contact", "Notes on contact");
		boolean b3 = cm1.contactExists(c1);
		System.out.println("Contact c1 exists in cm1 is " + b3);

		System.out.println("");
		System.out.println("TESTING contactExists(Set<Contact> contact)");
		Contact c2 = new ContactImpl ("Another Contact", "Notes on another contact");
		Set<Contact> setc0 = new HashSet<Contact>();
		setc0.add(c1);
		setc0.add(c2);
		cm1.addNewContact("First Contact", "Notes on first contact");
		cm1.addNewContact("Second Contact", "Notes on second contact");
		cm1.addNewContact("Another Contact", "Notes on another contact");
		Set<Contact> setc1 = new HashSet<Contact>();
		setc1 = cm1.getContacts("co");
		System.out.println("Set setc1: " + setc1);
		System.out.println("Set setc0: " + setc0);
		boolean b4 = cm1.contactExists(setc1);
		System.out.println("All the contacts in set setc1 exist in cm1 is " + b4);
		boolean b5 = cm1.contactExists(setc0);
		System.out.println("All the contacts in set setc0 exist in cm1 is " + b5);

		System.out.println("");
		System.out.println("TESTING contactExists(getAllMeetingList(Contact contact))");
		int fmn1 = cm1.addFutureMeeting(setc1, cal1);
		cm1.addNewPastMeeting(setc1, cal2, "Notes for new past meeting");
		Contact[] carray = new Contact[3];
		int i = 0;
		for (Contact next : setc1)
		{
			carray[i] = next;
			System.out.println(carray[i]);
			i++;
		}
		List<Meeting> lmx1 = cm1.getAllMeetingList(carray[0]);
		System.out.println(lmx1);
	}
*/


}