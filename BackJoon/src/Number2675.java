import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number2675 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		int stringNumber = Integer.parseInt( br.readLine() );
		
		for( int i = 0; i < stringNumber; i++ ) {
			String result = "";
			int stringLength =  br.read() - 48 ;
			String str = br.readLine();
			
			String[] strArray = str.trim().split("");
			for( int j = 0; j < strArray.length; j++ ) {
				for( int z = 0; z < stringLength; z++ ) {
					result += strArray[j];
				}
			}
			System.out.println( result );
		}
	}
}
