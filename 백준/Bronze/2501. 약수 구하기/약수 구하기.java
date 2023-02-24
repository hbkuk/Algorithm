import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		StringTokenizer st = new StringTokenizer( br.readLine(), " " );
		
		int N = Integer.parseInt( st.nextToken() );
		int K = Integer.parseInt( st.nextToken() );
		
		int i = 0;
		int j = 0;
		while( i <= N ) {
			i++;
			if( (N % i == 0) ) {
				j++;
				if( j == K ) {
					System.out.println( i );
					break;
				}
			}
		}
		
		 if( j < K) {
			System.out.println( 0 );
		 }
	}
}
