import java.util.Scanner;

public class Number2525_2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int hour = scan.nextInt();
		int minute = scan.nextInt();
		int time = scan.nextInt();
		scan.close();
		
		// 시간 
		if( ( (time/60) + hour ) >= 24 ) {
			
			hour = (time/60) + hour - 24 ;
		} else {
			
			hour = hour + (time/60);
		}
			

		if( (time % 60) + minute >= 60 ) {
			
			hour++;
			minute = ((time % 60) + minute) - 60;
			
			if(minute == 60) {
				hour ++;
				minute = 0;
			} 
			
			if( hour >= 24 ) {
				
				hour = hour - 24; 
			}
			
			} else {
				
				minute = ((time % 60) + minute);
			
				
			}

		System.out.println( hour + " " + minute );
		}
		
	}
	
