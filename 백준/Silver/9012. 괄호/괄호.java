import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 테스트 케이스 입력 받기
        int caseCount = Integer.parseInt(br.readLine());

        // 2. 전체 반복
        for (int i = 0; i < caseCount; i++) {  
            String[] datas = br.readLine().trim().split("");

            // 2-1. 양끝 괄호 확인
            if(!datas[0].equals("(") || !datas[datas.length-1].equals(")")) {
                System.out.println("NO");
                continue;
            }

            boolean isVPS = true;

            // 2-2. Stack 만들기
            Stack<String> stack = new Stack<>();
            
            for(String data : datas) {
                if(data.equals("(")) {
                    stack.push("(");
                } else {
                    if(stack.isEmpty()) {
                        isVPS = false;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(isVPS && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
