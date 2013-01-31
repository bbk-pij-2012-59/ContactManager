/**
* Test for the ContactImpl implimentation of the Contact interface
* 30th January 2013 - Created with four dummy tests - all set to fail
* 31st January 2013 - Real tests
*/

import org.junit.*;
import static org.junit.Assert.*;

public class TestContact
{
	private ContactImpl c1;
	private ContactImpl c2;

	@Before
	public void buildContact()
	{
		c1 = new ContactImpl ("Smith, John", "Not the deceased Labour politican");
		c2 = new ContactImpl ("Jones, Jack", "");
	}

	@Test
	public void testsGetId()
	{
		int output = c1.getId();
		int expected = 1001;
		assertEquals(output, expected);
		int output2 = c2.getId();
		int expected2 = 1002;
		assertEquals(output2, expected2);
	}

	@Test
	public void testsGetName()
	{
		String output = c1.getName();
		String expected = "Smith, John";
		assertEquals(output, expected);
		String output2 = c2.getName();
		String expected2 = "Jones, Jack";
		assertEquals(output2, expected2);
	}

	@Test
	public void testsGetNotes()
	{
		String output = c1.getNotes();
		String expected = "Not the deceased Labour politican";
		assertEquals(output, expected);
		String output2 = c2.getNotes();
		String expected2 = "";
		assertEquals(output2, expected2);

	}

	@Test
	public void testsAddNotes()
	{
		c1.addNotes("More data");
		String output = c1.getNotes();
		String expected = "Not the deceased Labour politicanMore data";
		assertEquals(output, expected);
		c2.addNotes("Notes about Jack");
		String output2 = c2.getNotes();
		String expected2 = "Notes about Jack";
		assertEquals(output2, expected2);
	}

}
