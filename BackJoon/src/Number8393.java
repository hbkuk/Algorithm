import java.util.Scanner;

public class Number8393 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int A = scan.nextInt();
		
		int result = 0;
		for( int i = 1; i <= A; i ++) {
			
			result += i;
		}
		
		System.out.println( result );
		
		scan.close();
		
	}

}
