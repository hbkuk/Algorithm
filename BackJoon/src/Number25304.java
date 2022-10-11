import java.util.Scanner;

public class Number25304 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 총 금액
		int totalAmount = scan.nextInt();
		
		// 물건의 수
		int totalnumber = scan.nextInt();
		
		// 1줄에 생성될 (가격 * 개수)를 담을 변수 선언 및 초기화
		int result = 0;
		
		for( int row = 1; row <= totalnumber; row++) {
			
			int price = scan.nextInt();
			int numberOfThings = scan.nextInt();
			
			result += (price * numberOfThings );
		}
		
		scan.close();
		
		if( totalAmount == result ) {
			System.out.println( "Yes" );
		} else {
			System.out.println( "No" );
		}
		
	}

}
