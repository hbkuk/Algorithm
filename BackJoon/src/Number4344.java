import java.util.Scanner;

public class Number4344 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int rowNumber = scan.nextInt();
		
		for( int i = 0; i < rowNumber; i++ ) {
			int caseNumber = 0;
			int score = 0;
			double avg = 0;
			int avgAboveCounting = 0;
			
			caseNumber = scan.nextInt();
			
			int[] studentScores = new int[caseNumber];
			
			for( int j = 0; j < caseNumber; j++ ) {
				
				score = scan.nextInt();
				avg += score;
				studentScores[j] = score;
			}
				avg = (avg/caseNumber);
			
			for( int z = 0; z < caseNumber; z++ ) {
				if( studentScores[z] > avg ) {
					avgAboveCounting ++;
				}
			}
			
			System.out.println(String.format("%.3f", ( (double) avgAboveCounting/caseNumber) * 100) + "%" );
			
		}
		
	}
}
