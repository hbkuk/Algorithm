import java.util.Scanner;

public class Number2480 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		
		scan.close();
		
		if( A == B && A == C) {
			
			System.out.println( 10_000 + (A * 1_000) );
			
		} else if( A == B ) {
			
			System.out.println( 1_000 + (A * 100) );
			
		} else if( B == C ) {
			
			System.out.println( 1_000 + (B * 100) );
			
		} else if( A == C ) {
			
			System.out.println( 1_000 + (A * 100) ); 
		} else {
			
			if( Math.max(A, B) > C) {
				
				System.out.println( (Math.max(A, B) * 100) );
				
			} else {
				
				System.out.println( (C * 100) );
				
			}
		}
	}
}
