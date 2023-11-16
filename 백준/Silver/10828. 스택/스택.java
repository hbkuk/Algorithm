import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());

        // 1. Stack 구현하기
        int size = 5;
        int lastIndex = 0;
        int[] array = new int[size];

        String[] data = new String[2];
        // 2. 문자열 "push 1"을 전달받으면 어떻게 분리할 것인지...
        for (int i = 0; i < testCount; i++) {
            data = br.readLine().split(" ");
            
            if(data[0].equals("push")) {
                if(array.length == lastIndex + 1) {
                    size = size * 2;
                    int[] newArray = new int[size];
                    for (int j = 0; j < array.length; j++) {
                        newArray[j] = array[j];
                    }
                    array = newArray;
                    array[lastIndex] = Integer.parseInt(data[1]);
                    lastIndex++;
                } else {
                    array[lastIndex] = Integer.parseInt(data[1]);
                    lastIndex++;
                }
                continue;
            }

            if(data[0].equals("pop")) {
                if(lastIndex != 0) {
                    System.out.println(array[lastIndex - 1]);
                    lastIndex--;
                } else {
                    System.out.println(-1);
                }
                continue;
            }
            
            if(data[0].equals("top")) {
                if(lastIndex != 0) {
                    System.out.println(array[lastIndex - 1]);
                } else {
                    System.out.println(-1);
                }
                continue;
            }

            if(data[0].equals("size")) {
                System.out.println(lastIndex);
                continue;
            }

            if(data[0].equals("empty")) {
                if(lastIndex == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                continue;
            }
        }
    }
}
