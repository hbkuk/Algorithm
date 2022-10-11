import java.util.Scanner;

public class Number2739 {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		int A = scan.nextInt();
		
		scan.close();
		
		for( int i = 1; i < 10; i ++ ) {
			
			System.out.println( A + " * " + i + " = " + (A*i));
		}
		
	}

}
