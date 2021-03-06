package training_class;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

public class Assignment2dot3 {

	
	public double getAvg(Object stud, int numSc){
		
		
		return (Double)stud/numSc;
	}
	
	public static void main( String [] args ) {
		
		//process
		//- create an arrayList from the first name and compare every other inserted
		//name by with .equals to determine if use exists
		//- 2 more arrayLists should be create and their indexes should correspond to
		// the name of each user. One list should have the total points of a user
		// the next list should contain the number of name repeats a user has. The
		// corresponding indexes from row 2 and 3 will be used to calculate the first average
		
		//- a table of the names, repeats and average should be displayed
		
		
		
		//action: testing the properties of arrayList.contains
//		ArrayList myList = new ArrayList();
//		myList.add("turkey");
//		myList.add("giving");
//		
//		if (myList.contains("giving")){
//			
//			System.out.println("The list contains turkey !");
//			
//		}else{
//			System.out.println("nope!");
//			
//		}
		
		ArrayList names = new ArrayList();
		ArrayList totSc = new ArrayList();//sum of each players scores
		ArrayList nosP = new ArrayList();//how many score a player had 
		
		
		//names[]
		File fill = new File("data.txt");//references the contents of a file
		
		Scanner inpStr;
		try {
			
			inpStr = new Scanner(fill);
		
			System.out.println("");
			//System.out.println(inpStr);
			
		while (inpStr.hasNextLine()){
			//action: as long as the file has text, the loop will continue
			
			String data = inpStr.nextLine();
			String[] piece = data.split(" ");//splits based on one space
			
			//System.out.println("piece 0 is: "+ piece[0]);
			//System.out.println("piece 1 is: "+ piece[1]);
			double Num = Double.parseDouble(piece[1]);
			
			if (names.contains(piece[0])){
				//action: don't add new name if already exists. Just increment number of score and add to total
//				
				int nameIndex = names.indexOf(piece[0]);
				
				
				double ts = (Double) totSc.get(nameIndex);
				
				double newVal = ts + Num;//
				
				totSc.set(nameIndex, newVal);
//				note: having trouble increment number within nosP
				
//				double str2Num = Double.parseDouble(piece[4]);// converts data from string
//				nosP.get(piece[1]);
				
				int newNos = (Integer) nosP.get(nameIndex);
				nosP.set(nameIndex, ++newNos);//increments and then updates tally of total number of scores
				
				//System.out.println("piece zero is: "+ piece[0]);
				//System.out.println("");
			}else{
				//action: add name; 
				names.add(piece[0]); //add new name
				
				//action: add to sum of corresponding totSc
				totSc.add(Num);
				
				//action: add new nosP
				nosP.add(1);
			}
//			
//			
			
			
			
			//System.out.println(piece[3] );//prints out last value in one row
			
			//nos++; //counting number of scores per student
			if (!(inpStr.hasNextLine())){
			
				System.out.println("names are: " + names );
				System.out.println("sums are: " + totSc );
				System.out.println("names are: " + nosP );
			
				
				Assignment2dot3 as3 =  new Assignment2dot3();
				
				Double totAvg = ((as3.getAvg( totSc.get(0), (Integer)nosP.get(0)) + as3.getAvg( totSc.get(0), (Integer)nosP.get(0)) + as3.getAvg( totSc.get(0), (Integer)nosP.get(0)) )  / names.size()) ;
				
				
				
				;
				
				System.out.println("");
				System.out.println("Number of students: " + names.size());
				System.out.println("Average student mark: " + totAvg);
				System.out.println("Standard deviation: TBD" );
				 
				//System.out.println(data);
			}
			
			
		}
		
		
		inpStr.close();
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		try {
//			//action: only using because data.txt does
//			// not exist yet as I'm typing this
//			
//			Scanner inpStr = new Scanner(file);
//			double sum = 0;
//			double nos = 0; //number of score;
//			
//			while (inpStr.hasNext()){
//				//action: as long as the file has text, the loop will continue
//				
//				String data = inpStr.next();
//				String[] piece = data.split(" ");//splits based on one space
//				System.out.println(piece[3] );//prints out last value in one row
//				double str2Num = Double.parseDouble(piece[4]);// converts data from string
//				
//				System.out.println(data);
//				nos++; //counting number of scores per student
//			}
//			//action: close input stream
//			inpStr.close();
//			
//			
//		}catch (FileNotFoundException e){
//			
//			e.printStackTrace();
//		}
//		
	}
	
	
	
}
