/**
* Test for the MeetingImpl implimentation of the Contact interface
* 31st January 2013 - Created
*/

import org.junit.*;
import static org.junit.Assert.*;

public class TestMeeting
{
	private MeetingImpl m1;
	private MeetingImpl m2;

	@Before
	public void buildContact()
	{
		m1 = new MeetingImpl ();//need to pass date and participants to constructor
		m2 = new MeetingImpl ();//need to pass date and participants to constructor
	}

	@Test
	public void testsGetId()
	{
		int output = m1.getId();
		int expected = 1001;
		assertEquals(output, expected);
		int output2 = m2.getId();
		int expected2 = 1002;
		assertEquals(output2, expected2);
	}

	@Test
	public void testsGetDate()
	{
		Calendar output = m1.getDate();
		Calendar expected = ;//need to check format of date/time
		assertEquals(output, expected);
		Calendar output2 = m2.getDate();
		Calendar expected2 = ;//need to check format of date/time
		assertEquals(output2, expected2);
	}

	@Test
	public void testsGetContacts()
	{
		Set<Contact> output = c1.getNotes();
		Set<Contact> expected = ;//need to check format of list of participants
		assertEquals(output, expected);
		Set<Contact> output2 = c2.getNotes();
		Set<Contact> expected2 = ;//need to check format of list of participants
		assertEquals(output2, expected2);

	}

}
