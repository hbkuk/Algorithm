import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		int N = Integer.parseInt( br.readLine() );
		
		int b5 = N / 5 ;
		int r = N % 5 ;
		
		if( r == 1 && b5 >= 1 ) {
			b5 = b5 - 1 + 2;
		} else if( r == 2 && b5 >= 2 ) {
			b5 = b5 - 2 + 4;
		} else if( r == 3 ) {
			b5 = b5 + 1;
		} else if( r == 4 && b5 >= 1 ) {
			b5 = b5 - 1 + 3;
		} else if( r == 0 ) {
			
		} else {
			b5 = -1;
		}
		
		System.out.println( b5 );
	}
}
