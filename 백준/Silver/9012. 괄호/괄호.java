import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 테스트 케이스 입력 받기
        int caseCount = Integer.parseInt(br.readLine());

        // 2. 전체 반복
        for (int i = 0; i < caseCount; i++) {  
            String input = br.readLine().trim();
            boolean isVPS = isVPS(input);
            printResult(isVPS);
        }
    }

    public static boolean isVPS(String data) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : data.toCharArray()) {
            if(c == ('(')) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void printResult(boolean result) {
        if(result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
