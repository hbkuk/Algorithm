import java.util.Scanner;

public class Number10818 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int length = scan.nextInt();
		
		// 첫 줄에 입력받은 값을 배열의 크기로 설정
		int[] Array = new int[length];
		
		// 둘째 줄에서 데이터 입력받아 대입
		for( int i = 0; i < length; i++) {
			Array[i] = scan.nextInt();
		}
		
		int tempNum = 0;
		
		for( int loop = 0; loop < Array.length - 1; loop++) {
			
			for ( int j = 0; j < Array.length - 1 - loop ; j++ ) {
				
				if(Array[j] < Array[j+1]) {
				
				} else {	//Array[j] < Array[j+1]
					tempNum = Array[j];
					Array[j] = Array[j+1];
					Array[j+1] = tempNum;
				}
			}

		} 
		
		System.out.print( Array[0] +" " );
		System.out.print( Array[Array.length-1] );
	}
}
