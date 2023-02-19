import java.util.Scanner;

public class Number5597 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner( System.in );
		
		// 1. 크기가 30인 배열을 만든다.
		int[] array = new int[30];
		
		// 2. 입력받은 수를 통해서, 해당 배열의 idx 표시를 한다.
		for( int i = 0; i < 28; i ++) {
			
			int a = scan.nextInt();
			
			// 3. 입력받은 수를 배열의 idx에 1로 대입한다.
			array[a - 1] = 1;
			
		}
		
		// 4. 배열을 전체 순회하면서, 값이 0인 idx를 출력한다.
		
		for( int i =0; i < 30; i++) {
			
			if( array[i] == 0) {
				
				System.out.println( i + 1 );
			}
			
		}
	}

}
