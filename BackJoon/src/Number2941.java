import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number2941 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String str = br.readLine();
		
		int strLength = str.length();
		
		for( int i = 0; i < str.length(); i++ ) {
			if( str.charAt(i) == 'c') {
				if( i + 1 < str.length() ) {
					if( ( str.charAt(i + 1) == '=' ) || ( str.charAt(i + 1) == '-' ) ) {
						strLength-=1;
						i++;
					}
				}
			} else if( str.charAt(i) == 'd') {
				
				if( i + 2 < str.length() ) {
					if( ( str.charAt(i + 1) == 'z' ) ) {
						if( ( str.charAt(i + 2) == '=' ) ) {
							strLength-=2;
							i+=2;
						}
					}
				}
				
				if( i + 1 < str.length() ) {
					if( ( str.charAt(i + 1) == '-' ) ) {
						strLength-=1;
						i++;
					}
				}
			} else if( str.charAt(i) == 'l') {
				if( i + 1 < str.length() ) {
					if( ( str.charAt(i + 1) == 'j' ) ) {
						strLength-=1;
						i++;
					}
				}
			} else if( str.charAt(i) == 'n') {
				if( i + 1 < str.length() ) {
					if( ( str.charAt(i + 1) == 'j' ) ) {
						strLength-=1;
						i++;
					}
				}
			} else if( str.charAt(i) == 's') {
				if( i + 1 < str.length() ) {
					if( ( str.charAt(i + 1) == '=' ) ) {
						strLength-=1;
						i++;
					}
				}
			} else if( str.charAt(i) == 'z') {
				if( i + 1 < str.length() ) {
					if( ( str.charAt(i + 1) == '=' ) ) {
						strLength-=1;
						i++;
					}
				}
			}
		}
			System.out.println( strLength );
	}
}


