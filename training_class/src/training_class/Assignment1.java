package training_class;

import java.util.Scanner;


public class Assignment1 {

	
	
	public static void main(String Args[]){
		
		
		
		int chance = 0;

		int answer = 7;
		
		System.out.println("please guess with a number");
		Scanner scan = new Scanner(System.in);

		int guess;
		
		while ( chance < 5){

				guess = scan.nextInt();
				
				if ( guess == answer ){
					
					System.out.println("You got it");
					break;
				}
				
				
				
				
				if ( ( guess >= answer && guess <= answer+10  )   ||   ( guess <= answer && guess >= answer-10  ) ){
				 
					System.out.println("the answer is: " + answer);
					
					break;
					
				}else{
					
					if ((chance+1) <=4 ){
						System.out.println("keep trying");
					}
				}
					
				
				

				chance++;
		}

	//	if ( chance >=5 && guess != answer ){
			
	//		System.out.println("Sorry");
	//	}	
		
		if ( chance >=5 ){
			
			System.out.println("Sorry, you're out of chances");
		}	
		
		
		
	}
	
	
	
	
	
	
	
}


