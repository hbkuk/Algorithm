import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 자연수 N
        int givenArraySize = Integer.parseInt(br.readLine());

        // 2. N개의 정수 => givenIntegers
        String[] givenIntegerStrings = br.readLine().split(" ");
        int[] givenArray = new int[givenArraySize];

        for (int i = 0; i < givenIntegerStrings.length; i++) {
            givenArray[i] = Integer.parseInt(givenIntegerStrings[i]); // 각 문자열을 int로 변환하여 배열에 저장
        }

        Arrays.sort(givenArray);

        // 3. M
        int searchArraySize = Integer.parseInt(br.readLine());

        // 4. M개의 수 => searchValues
        String[] searchIntegeStrings = br.readLine().split(" ");
        int[] searchArray = new int[searchArraySize];

        for (int i = 0; i < searchIntegeStrings.length; i++) {
            searchArray[i] = Integer.parseInt(searchIntegeStrings[i]); // 각 문자열을 int로 변환하여 배열에 저장
        }

        for(int searchValue : searchArray) {
            int start = 0;
            int end = givenArraySize - 1;
            boolean isFounded = false;

            while(start <= end) {
                int mid = (start + end) / 2;

                if(searchValue == givenArray[mid]) {
                    isFounded = true;
                    break;
                }

                if(searchValue < givenArray[mid]) {
                    end = mid - 1;
                }

                if(searchValue > givenArray[mid]) {
                    start = mid + 1;
                }
            }
            if(isFounded) {
                 sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        br.close();

        System.out.println(sb);
    }
}
