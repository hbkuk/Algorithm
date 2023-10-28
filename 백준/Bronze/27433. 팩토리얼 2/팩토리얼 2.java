import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long result = factorial(N);
        System.out.println(result);
    }

    public static Long factorial(int number) {
        if (number <= 1) {
            return 1L;
        }
        return number * factorial(number - 1);
    }
}
