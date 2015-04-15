package training_class;

import java.util.*;

public class Assignment2dot1 {


	public int getSize(Set mine){
		
		return mine.size();
	}
	
	//public class SetDemo {

		  public static void main( String [] args ) {

		    // Create a set called mySet
		    Set mySet = new HashSet();
		    
		    Assignment2dot1 myClass = new Assignment2dot1();

		    // Ensure that this set contains an interesting selection of fruit 
		    String fruit1 = "pear", fruit2 = "banana", fruit3 = "tangerine",
		                            fruit4 = "strawberry", fruit5 = "blackberry";
		    mySet.add( fruit1 );
		    mySet.add( fruit2 );
		    mySet.add( fruit3 );
		    mySet.add( fruit2 );
		    mySet.add( fruit4 );
		    mySet.add( fruit5 );

		    // Display contents of mySet
		    System.out.println( "mySet now contains:" );
		    System.out.println( mySet );
		    
		    System.out.println("");//line break 
		    
		    //action: return size of set
		    System.out.println( "mySet now has size: "+ myClass.getSize(mySet));
		    
		    //action: removing 2 fruits
		    System.out.println("");//line break
		    mySet.remove(fruit4);
		    mySet.remove(fruit5);
		    System.out.println( "mySet now contains:" );
		    System.out.println( mySet );
		    

		    System.out.println("");//line break 
		    
		    //action: remove the rest of the fruits
		    mySet.removeAll(mySet);
		    
		    System.out.println( "mySet now contains:" );
		    System.out.println( mySet );
		    
		    //action: checking if set is empty
		    System.out.println("");//line break 
		    System.out.println( "is mySet empty ?" );
		    if (mySet.isEmpty()){
		    	
		    	System.out.println( "Yes my set is empty" );
		    }
		    
		    
		    

		 }
	//}

	
	
	
	
}
