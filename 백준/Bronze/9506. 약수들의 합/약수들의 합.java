import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		while( true ) {
			
			StringTokenizer st = new StringTokenizer( br.readLine() );
			int N = Integer.parseInt( st.nextToken() );
			
			if( N != -1 ) {
				int result = 1;
				StringBuilder sb = new StringBuilder();
				int i = 1;
				sb.append( N + " = 1" );
				while( true ) {
					
					i++;
					if( i < N ) {
						
						if( (N % i == 0) ) {
							result += i;
							sb.append( " + " + i );
						}
						
					} else {
						if( result == N ) {
							System.out.println(sb.toString());
							break;
						} else {
							System.out.println( N + " is NOT perfect.");
							break;
						}
					}
				}
			} else {
				break;
			}
		}
	}
}
