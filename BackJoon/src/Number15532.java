import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number15532 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		
		int A1 = Integer.parseInt(A);
		
		String result = "";
		
		for( int repeat = 1; repeat <= A1; repeat++ ) {
			
			String B = br.readLine();
			
			StringTokenizer st = new StringTokenizer(B);
			
			int B1 = Integer.parseInt(st.nextToken());
			int B2 = Integer.parseInt(st.nextToken());
			
		}
		
		
	}
}
