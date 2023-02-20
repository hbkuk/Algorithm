import java.util.Scanner;

public class Number1065_2 {
	
	public boolean hanSuCheck( int number ) {
		
		return false;
	}

	public static void main(String[] args) {
		
		// 1. 수를 입력받는다.
		// 2. 1부터 입력받은 수 까지의 한수를 확인한다.
		// 3. 한수의 갯수를 출력한다..
		
		Scanner scan = new Scanner(System.in);
		
		int number = scan.nextInt();
		
		int hanSuCounting = 0;
		
		for( int i = 1; i <= number; i++ ) {
			
			if( i < 10 ) {
				hanSuCounting++;
			} else if( i < 100 ) {
				hanSuCounting++;
			} else if( i < 1000 ) {
				if( (i / 100) - ( i % 100 /10 ) == ( i % 100 /10) - ( i % 10) ) {
					hanSuCounting++;
				}
			}
		}
		System.out.println( hanSuCounting );
	}
}
