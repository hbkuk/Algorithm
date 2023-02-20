import java.util.Scanner;

public class Number11720 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 1. 첫째줄의 숫자의 갯수를 입력받는다.
		int numberLenth = scan.nextInt();
		
		// 2. 숫자 n개가 나열된 문자열을 입력받는다.
		String numbers = scan.next();
		
		// 3. split 메서드를 통해 쪼개서 계산하거나, charAt을 통해서 계산한다.
		String[] array = numbers.split("");
		
		// 4. 합산
		int sum = 0;
		for( int i = 0; i < array.length; i++ ) {
			
			sum += Integer.parseInt( array[i] );
		}
		
		System.out.println( sum );
		
		
	}
}
