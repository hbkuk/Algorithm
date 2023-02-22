import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        
		double majorSubjectAvg = 0;
		double creditSum = 0;
		
		for( int i = 1; i <= 20; i++ ) {
			
			String str = br.readLine();
			
			String[] strArray = str.split(" ");
			
			String grade = strArray[2];
			
			if( !grade.equals("P") ) {
				
				double credit = Double.parseDouble( strArray[1] );
				
				double gradeAvg = 0;
				
				if( grade.equals("A+") ) {
					gradeAvg = 4.5;
				} else if( grade.equals("A0") ) {
					gradeAvg = 4.0;
				} else if( grade.equals("B+") ) {
					gradeAvg = 3.5;
				} else if( grade.equals("B0") ) {
					gradeAvg = 3.0;
				} else if( grade.equals("C+") ) {
					gradeAvg = 2.5;
				} else if( grade.equals("C0") ) {
					gradeAvg = 2.0;
				} else if( grade.equals("D+") ) {
					gradeAvg = 1.5;
				} else if( grade.equals("D0") ) {
					gradeAvg = 1.0;
				}
				
				majorSubjectAvg += credit * gradeAvg;
				creditSum += credit;
			}
			
		}
		
		System.out.println( majorSubjectAvg / creditSum );
		
	}		

}
