import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		int n = Integer.parseInt( br.readLine() );
		
		int groupNumber = 1;
		
		int a = 1;
		
		while( n > a ) {
			groupNumber++;
			a = groupNumber + ( ( groupNumber - 1 ) * groupNumber / 2 );
		}
		
		int position = groupNumber - ( a - n );
		
		if( groupNumber % 2 == 0 ) {
			System.out.println( position + "/" +  ( (groupNumber + 1 ) - position ) );
		} else {
			System.out.println( ( (groupNumber + 1 ) - position ) + "/" + position );
		}
		
	}		
}
