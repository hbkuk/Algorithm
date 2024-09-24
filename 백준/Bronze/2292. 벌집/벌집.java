import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		
		int n = Integer.parseInt( br.readLine() );
		
		n--;
		if( n == 0 ) {
			System.out.println( 1 );
		} else {
			
			int range = 1;
			int roomCount = 1;
			
			while( n > 0 ) {
				
				n = n - ( 6 * range );				
				range++;
				roomCount++;
			}
			
			System.out.println( roomCount );

		}
	}		
}
