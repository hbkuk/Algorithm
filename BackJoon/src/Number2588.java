import java.util.Scanner;

public class Number2588 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int A = scan.nextInt();
		
		String B = scan.next();
				
		int[] BInt = new int[B.length()];
		
		for( int i = 0; i < B.length(); i++ ) {
			
			BInt[i] = B.charAt(i) - '0' ;
		}
		
		int result = 0;
		for(int print = 0; print < BInt.length; print++) {
			
			System.out.println( (int)(A * (BInt[(BInt.length-1) - print] * Math.pow(10, print)) /  Math.pow(10, print) ) );
			
			result += A * (BInt[(BInt.length-1) - print] * Math.pow(10, print));
		}
		
			System.out.println( (int)result );

		
		scan.close();
	}

}
