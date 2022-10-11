import java.util.Scanner;

public class Number2525 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int hour = scan.nextInt();
		int minute = scan.nextInt();
		int time = scan.nextInt();
		scan.close();
		
		//  
		if( (time/60) > (24 - hour) ) {
			
			System.out.println( time/60 ); 
			
			hour = (time/60) - (24 - hour);
			
		} else {
			
			System.out.println( time/60 ); 
			
			hour = hour + (time/60);
		}
		
		if( minute + ( time % 60 ) > 59 ) {
			
			if( hour == 23) {
				hour = 0;
				minute = minute + ( time % 60 ) - 60;
				
			} else {
				
				minute = minute + ( time % 60 );
			}

		System.out.println( hour + " " + minute );
	}
}}
