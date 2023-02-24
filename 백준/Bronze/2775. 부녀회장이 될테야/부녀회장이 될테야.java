import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		int T = Integer.parseInt( br.readLine() );
		
		int[][] array = new int[15][15];
		
		
		for( int i = 1; i <= 14; i++ ) {
			
			array[0][i] = i;
		}
		
		int p = 0;
		for( int j = 1; j <= 14; j++ ) {
			
			for( int z = 1; z <= 14; z++ ) {
				
				if( z == 1 ) {
					array[j][z] = array[j - 1][z];
				} else {
					array[j][z] = array[j - 1][z] + array[j][z - 1];
				}
			}
			
		}
		
		for( int z = 1; z <= T; z++ ) {
			int F = Integer.parseInt( br.readLine() );
			int H = Integer.parseInt( br.readLine() );
			System.out.println( array[F][ H ] );
		}
	}
}
