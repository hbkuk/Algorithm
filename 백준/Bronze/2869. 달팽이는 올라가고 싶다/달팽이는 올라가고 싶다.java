import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str, " ");
		
		int A = Integer.parseInt( st.nextToken() );
		
		int B = Integer.parseInt( st.nextToken() );
		
		int V = Integer.parseInt( st.nextToken() );
		
		
		System.out.println( String.format("%.0f", Math.ceil( (double) ( V - B ) / ( A - B )) ) );
	}
}
