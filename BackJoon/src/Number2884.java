import java.util.Scanner;

public class Number2884 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int A = scan.nextInt();
		
		int B = scan.nextInt();
		
		scan.close();

		if( B >= 45 ) {
			
			B = B - 45;
			
		} else if( B < 45 ) {
			
			B = (B + 60) - 45;
			
			if( A == 0 ) {
				A = 23;
			} else {
				
				A--;
			}
		}
		
		System.out.println( A +" "+ B);
	}
}
