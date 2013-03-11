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
		cmd1.launch2();
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
		System.out.println("Meeting number: " + m1.getId());
		System.out.println("Meeting date: " + m1.getDate());
		System.out.println("Meeting participants: " + m1.getContacts());

		FutureMeeting m2 = new FutureMeetingImpl(setc1, cal1);
		System.out.println("Meeting number: " + m2.getId());
		System.out.println("Meeting date: " + m2.getDate());
		System.out.println("Meeting participants: " + m2.getContacts());

		PastMeeting m3 = new PastMeetingImpl(setc1, cal1, "Notes about third meeting");
		System.out.println("Meeting number: " + m3.getId());
		System.out.println("Meeting date: " + m3.getDate());
		System.out.println("Meeting participants: " + m3.getContacts());
		System.out.println("Meeting notes: " + m3.getNotes());

		PastMeeting m4 = new PastMeetingImpl((FutureMeetingImpl) m2, "Notes about fourth meeting");
		System.out.println("Meeting number: " + m4.getId());
		System.out.println("Meeting date: " + m4.getDate());
		System.out.println("Meeting participants: " + m4.getContacts());
		System.out.println("Meeting notes: " + m4.getNotes());

	}

	public void launch2()
	{
		ContactManager cm1 = new ContactManagerImpl();
		System.out.println(cm1);
		//System.out.println(cm1.AllMeetings);
		//System.out.println(cm1.AllContacts);


		//TESTING addFutureMeeting(Set<Contact> contacts, Calendar date)
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

		//TESTING getMeeting(int id)
		Meeting mx1 = cm1.getMeeting(1001);
		Meeting mx2 = cm1.getMeeting(1002);
		System.out.println("Meeting number: " + mx1.getId());
		System.out.println("Meeting date: " + mx1.getDate());
		System.out.println("Meeting participants: " + mx1.getContacts());
		System.out.println("Meeting number: " + mx2.getId());
		System.out.println("Meeting date: " + mx2.getDate());
		System.out.println("Meeting participants: " + mx2.getContacts());

		//TESTING addNewPastMeeting(Set<Contact> contacts, Calendar date, String text)
		cm1.addNewPastMeeting(setc2, cal2, "Notes for new past meeting");
		Meeting mx3 = cm1.getMeeting(1003);
		System.out.println("Meeting number: " + mx3.getId());
		System.out.println("Meeting date: " + mx3.getDate());
		System.out.println("Meeting participants: " + mx3.getContacts());



		//List<Meeting> lm1 = new ArrayList<Meeting>();



	}



}