import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine(); // 0과 1로 이루어진 문자열
        int zeroCount = 0;
        int oneCount = 0;

        // 1. 0과 1의 개수 계산
        for (char c : line.toCharArray()) {
            if (c == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        int removeZero = zeroCount / 2; // 제거해야 할 0의 개수
        int removeOne = oneCount / 2;  // 제거해야 할 1의 개수

        StringBuilder result = new StringBuilder();
        char[] chars = line.toCharArray();

        // 2. 0을 뒤에서부터 제거
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '0' && removeZero > 0) {
                chars[i] = 'X'; // 제거된 0 표시
                removeZero--;
            }
        }

        // 3. 1을 앞에서부터 제거
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1' && removeOne > 0) {
                chars[i] = 'X'; // 제거된 1 표시
                removeOne--;
            }
        }

        // 4. 결과 문자열 구성
        for (char c : chars) {
            if (c != 'X') { // 제거된 문자는 제외
                result.append(c);
            }
        }

        System.out.println(result);
    }
}
