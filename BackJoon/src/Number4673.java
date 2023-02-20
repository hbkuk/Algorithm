
public class Number4673 {

	public static void main(String[] args) {
		
		int selfNumberIdx = 0;
		
		int[] selfNumbers = new int[10_001];
		
		// 1. 1부터 시작해서, 셀프 넘버 출력 
		for( int i = 1; i <= 10_000; i++ ) {
			
			// 10 미만 
			if( i < 10 ) {
			selfNumberIdx = i + i;
			
			// 100 미만
			} else if( i < 100 ) {
			selfNumberIdx = i + i/10 + i%10 ;
				
			// 1_000 미만
			} else if( i < 1_000 ) {
			selfNumberIdx = i + i/100 + ( ( i / 10 ) % 10 ) + ( i % 10 );
			
			// 10_000 미만
			} else if( i < 10_000 ) {
				selfNumberIdx = i + i/1000 + ( ( i / 100 ) % 10 ) + ( ( i / 10 ) % 10 ) + ( i % 10 );
			}
			
			if( !( selfNumberIdx > 10_000 ) ) {
				selfNumbers[ selfNumberIdx ] = 1;
				selfNumberIdx = 0;
			}
		}
		
		// 3. 전체 순회하면서 셀프넘버에 없는 숫자 출력
		
		for( int j = 1; j < 10_001; j++ ) {
			
			if( selfNumbers[j] != 1 ) {
				System.out.println( j );
			}
		}
	
	}
}
