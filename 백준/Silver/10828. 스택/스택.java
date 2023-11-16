import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCount = Integer.parseInt(br.readLine());

        int size = 5;
        int lastIndex = 0;
        int[] array = new int[size];
        
        for (int i = 0; i < testCount; i++) {
            String[] data = br.readLine().split(" ");
            
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
                    sb.append(array[lastIndex - 1]).append('\n');
                    lastIndex--;
                } else {
                    sb.append(-1).append('\n');
                }
                continue;
            }
            
            if(data[0].equals("top")) {
                if(lastIndex != 0) {
                    sb.append(array[lastIndex - 1]).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
                continue;
            }

            if(data[0].equals("size")) {
                sb.append(lastIndex).append('\n');
                continue;
            }

            if(data[0].equals("empty")) {
                if(lastIndex == 0) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
                continue;
            }
        }
        System.out.println(sb);

        br.close();
    }
}
