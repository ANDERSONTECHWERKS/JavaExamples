package recursionExamples;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import recursionExamples.LinkedList;
import recursionExamples.RecursiveMethods;

public class Tests {
	static LinkedList<String> stringList = new LinkedList<String>();
	static {
		stringList.add("monke");
		stringList.add("banana");
		stringList.add("harambe");
		stringList.add("anotherbanana");
		stringList.add("donkeykong");
	}
	
	@Test
	public void testCreateLinkedList() {
		assertTrue(stringList.size() == 5);
	}
	
	@Test
	public void testRemoveFromLinkedList() {
		LinkedList<String> stringList = new LinkedList<String>();
		stringList.add("monke");
		stringList.add("banana");
		stringList.add("harambe");
		stringList.add("anotherbanana");
		stringList.add("donkeykong");
		
		stringList.remove("banana");
		stringList.remove("monke");

		assertTrue(stringList.size() == 3);
	}
	
	@Test
	public void testRecursiveProduct() {
		int a = 2;
		int b = 2;
		int c = 4;
		int d = 5;
		assertTrue(RecursiveMethods.recursiveProduct(a,b) == 4);
		assertTrue(RecursiveMethods.recursiveProduct(c,d) == 20);

	}
	
	@Test
	public void testRecursiveLetterCounter() {
		String testString = "monke";
		String testString2 = "banana";
		int a = RecursiveMethods.recursiveLetterCounter(testString, 'o');
		int b = RecursiveMethods.recursiveLetterCounter(testString2, 'n');

		assertTrue(a == 1);
		assertTrue(b == 2);
	}
}
