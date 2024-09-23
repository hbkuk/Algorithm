import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if (s.equals("0 0 0")) {
                break;
            }
            String[] split = s.split(" ");
            
            int first = toNumber(split[0]);
            int second = toNumber(split[1]);
            int third = toNumber(split[2]);
            
            List<Integer> collect = Stream.of(first, second, third).sorted().collect(Collectors.toList());
            
            // 삼각형이 성립하지 않는 경우
            if (collect.get(2) >= (collect.get(1) + collect.get(0))) {
                System.out.println("Invalid");
            }
            // Equilateral : 세 변의 길이가 모두 같은 경우
            else if (first == second && second == third) {
                System.out.println("Equilateral");
            }
            // Isosceles : 두 변의 길이만 같은 경우
            else if (first == second || second == third || first == third) {
                System.out.println("Isosceles");
            }
            // Scalene : 세 변의 길이가 모두 다른 경우
            else {
                System.out.println("Scalene");
            }
        }
        
    }
    
    private static int toNumber(String value) {
        return Integer.parseInt(value);
    }
    
}
