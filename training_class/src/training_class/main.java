package training_class;

import java.util.Scanner;


public class main {

	
	
	public void gameNow(){
		
		
		
		int chance = 0;

		int answer = 7;
		
		System.out.println("please guess with a number");
		Scanner scan = new Scanner(System.in);

		int guess;
		
		while ( ( guess >= answer && guess <= answer+10  )   ||   ( guess <= answer && guess >= answer-10  )){

				guess = scan.nextInt();

				if ( chance < 5){
				 
					System.out.println("keep trying");
		
				}else{
					
					System.out.println("Sorry");
					
					break;
		
				}

				chance++;
		}

		
		
		
	}
	
	
	
	
	
	
	
}


