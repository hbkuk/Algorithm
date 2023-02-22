import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number1316 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 첫째 줄에 단어의 갯수를 입력받는다.
		int rowNum = Integer.valueOf( br.readLine() );
		int result = rowNum;
		// 2. 단어의 갯수 만큼 for문을 반복시킨다.		
		for( int i = 0; i < rowNum; i++ ) {
			int[] sameAlphabetCounting = new int[26];
			String str = br.readLine();
			// 3. 단어의 길이만큼 for문을 반복시킨다.
			for( int j = 0; j < str.length(); j++ ) {
				
				int arrayIndex = str.charAt(j) - 97;
				
				//4. 이전에 카운팅 되지 않았다면, i + 1 했을때 동일한 문자인지 확인한다.(반복)
				if( sameAlphabetCounting[arrayIndex] == 0 ) {
					int z = j;
					// 4-1. i + 1 했을때 동일한 문자인지 확인한다.(반복)
					while( (z + 1) < str.length() && str.charAt(z) == str.charAt(z+1) ) {
						z++;
					}
					j = z;
					sameAlphabetCounting[arrayIndex]++;
				// 5. 동일하지 않다면, 반복문을 종료한다.					
				} else if( sameAlphabetCounting[arrayIndex] == 1 ) {
					result--;
					break;
				}
			}
		}
		System.out.println( result );
	}
}
