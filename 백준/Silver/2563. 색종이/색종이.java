import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		boolean[][] array = new boolean[101][101];
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		int rowNum = Integer.parseInt( br.readLine() );
		
		int dimension = 0;
		
		for( int i = 0; i < rowNum; i++ ) {
			StringTokenizer st = new StringTokenizer( br.readLine(), " " );
			
			int row = Integer.parseInt( st.nextToken() );
			int col = Integer.parseInt( st.nextToken() ) ;
			
			for( int j = 0; j < 10; j++ ) {
				for( int z = 0; z < 10; z++ ) {
					array[(row + j)][(col + z)] = true;
				}
			}
		}
		for( boolean[] row : array ) {
			for( boolean col : row ) {
				if( col == true ) {
					dimension++;
				}
			}
		}
		
		System.out.println( dimension );
	}
}
