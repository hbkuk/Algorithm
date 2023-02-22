import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer( str, " " );
		
		int rowNum = Integer.valueOf( st.nextToken() );
		
		int colNum = Integer.valueOf( st.nextToken() );
		
		int[][] array = new int[ rowNum ][ colNum ];
		
		for( int i = 0; i < 2; i++) {
			for( int j = 0; j < rowNum; j++) {
				str = br.readLine();
				
				st = new StringTokenizer( str, " " );
				
				for( int z = 0; z < colNum; z++ ) {
					array[j][z] += Integer.valueOf( st.nextToken() );
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for( int j = 0; j < rowNum; j++) {
			for( int z = 0; z < colNum; z++ ) {
				if( z != 2 ) {
					sb.append( array[j][z] + " " );
				} else {
					sb.append( array[j][z] + "\n" );
				}
			}
		}
		System.out.println( sb.toString() );
	}
}
