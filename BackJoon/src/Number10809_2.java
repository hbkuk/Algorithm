import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number10809_2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		String str = br.readLine();
		
		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
		for( int i = 0; i < 26; i++ ) {
			
			if( i <= 24) {
			System.out.print( str.indexOf(alphabet[i]) + " " );
			} else {
				System.out.print( str.indexOf(alphabet[i]) );
			}
			
		}
		
	}
}
