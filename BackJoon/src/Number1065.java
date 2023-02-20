import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number1065 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		System.out.print(hansuCountingNumber(Integer.parseInt(br.readLine())));
		
	}
	
	public static int hansuCountingNumber( int num ) {
		
		int cnt = 0;
		
		if( num < 100 ) {
			return num;
			
		} else {
			cnt = 99;
			for( int i = 100; i <= num; i++ ) {
				int hun = (i / 100);
				int ten = ( i % 100 /10 );
				int one = ( i % 10 );
				
				if( ( hun - ten ) == ( ten - one ) ) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
