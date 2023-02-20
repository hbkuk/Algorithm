import java.util.Scanner;

public class Number10809 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		
		scan.close();
		
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
