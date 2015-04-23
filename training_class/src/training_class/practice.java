package training_class;

import java.util.ArrayList;
import java.util.Arrays;

public class practice {

	
	
	
//	public ArrayList<Integer> someNumbers(){
//		
//		
//		ArrayList<Integer> tea = new  ArrayList<Integer>();
//		
//		tea.add(1);
//		tea.add(2);
//		tea.add(3);
//		tea.add(4);
//		tea.add(5);
//		
//		
//		return tea;
//	}
	
	
	public ArrayList<Integer> someStuff(){
		//action: pass in numbers in string format and then spit out the values
		
		String[] stuff = new String[]{"4","5","6","7","8"};
		
		ArrayList<Integer> smuv = new ArrayList<Integer>();
		
		
		smuv.add(Integer.parseInt(stuff[0]));
		smuv.add(Integer.parseInt(stuff[1]));
		smuv.add(Integer.parseInt(stuff[2]));
		smuv.add(Integer.parseInt(stuff[3]));
		smuv.add(Integer.parseInt(stuff[4]));
		
		
		
		return smuv;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
 for (int yup : new practice().someStuff() ){
	 
	 System.out.println(" the number is: " + yup);
	 
 }
		
		
		
		
		
		
	}

}
