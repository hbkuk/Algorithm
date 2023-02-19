import java.util.Scanner;

public class Number8958 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int rowCount = scan.nextInt();
		
		int counting = 0;
		
		int result = 0;
		
		for( int i = 1; i <= rowCount; i++ ) {
			
			String[] str = scan.next().split("");
			
			for( int j = 0; j < str.length; j++ ) {
				
				if( str[j].equals("O")) {
					counting++;
					result = result + counting; 
				} else if( str[j].equals("X")) {
					counting = 0;
				}
			}
			
			System.out.println( result );
			counting = 0;
			result = 0;
		}
	}
}
