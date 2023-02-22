import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		int largeNum = 0;
		int largeNumPositionRow = 0;
		int largeNumPositionCol = 0;
		
		int colCount = 0;
		for( int i = 0; i < 9; i++ ) {
			
			String str = br.readLine();
			
			StringTokenizer st = new StringTokenizer( str, " " );
			
			for( int j = 0; j < 9; j++) {
				int tempToken = Integer.parseInt( st.nextToken() );
				if( largeNum <= tempToken ) {
					largeNum = tempToken;
					largeNumPositionRow = i + 1 ;
					largeNumPositionCol = j + 1;
				}
			}
		}
		
		System.out.println( largeNum );
		System.out.print( largeNumPositionRow + " ");
		System.out.print( largeNumPositionCol );
	}
}
