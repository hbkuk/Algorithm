import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number1157 {
	
	public static void main(String[] args) throws IOException {
		
		int[] sameCnt = new int[26];
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		String str = br.readLine();
		
		for( int i = 0; i < str.length(); i++ ) {
			
			if( (int) str.charAt(i) >= 65 && (int) str.charAt(i) <= 90 ) {
				
				sameCnt[ (int) str.charAt(i) - 65 ]++;
				
			} else if( (int) str.charAt(i) >= 97 && (int) str.charAt(i) <= 122 ) {
				
				sameCnt[ (int) str.charAt(i) - 97 ]++;
			}
		}
		
		
		int flag = 0;
		int largestIndex = 0;
		
		//3. 배열을 순회하면서 가장 큰 숫자를 찾는다.
		for( int z = 0; z < sameCnt.length; z++ ) {
			if( sameCnt[z] > sameCnt[largestIndex] ) {
				largestIndex = z;
			}
		}
		
		//4. 다시 순회하면서 가장 큰 숫자가 배열에 또 있는지 확인한다.
		for( int z = 0; z < sameCnt.length; z++ ) {
			if( z != largestIndex && (sameCnt[z] == sameCnt[largestIndex]) ) {
				flag = 1;
			}
		}
		
		if( flag == 1 ) {
			System.out.println( "?" );
		} else {
			System.out.println( (char) (largestIndex + 65) );
		}
		
		
	}
}
