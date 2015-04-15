package training_class;

//import java.util.ArrayList;
//import java.util.Iterator;
import java.util.*;

public class Assignment2dot2 {
	
	
	
	
	public static void main( String [] args ) {
		
		//ArrayList<String> listName = new ArrayList<>(); //array list can expand in size and type
		//can be defined within the bracket
		
		ArrayList myList = new ArrayList(5);
		
		//a pear, a banana, a tangerine, a strawberry and a blackberry 
		
		
		
		myList.add("pear");
		myList.add("banana");
		myList.add("tangerine");
		myList.add("strawberry");
		myList.add("blackberry");
		
		Iterator iter = myList.iterator();// this has to be placed AFTER adding to the list or else will get an error
		
		//System.out.println(myList); // this works
		
		
		System.out.println("Forward List \n");
		while(iter.hasNext()){//
			//action: iterate over the list and display its elements
			
			System.out.println(iter.next());
		}
		
		System.out.println("");// line break
		

		ListIterator liter = myList.listIterator();
		System.out.println("Reverse List \n");
		
		for (int i=0;i<5;i++){
		//action: have to increment the proverbial "pointer" to the last element
			// of the list in order to go backwards.
			liter.next();
			
		}
		
		while(liter.hasPrevious()){//
			//action: iterate over the list and display its elements in REVERSE
			
			System.out.println(liter.previous());
		}
		
		
		//action: inserting second banana
		myList.add(3, "banana");
		System.out.println("new list: "+ myList);
		
	}
	

}
