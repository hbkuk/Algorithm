import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // 국가 수
        int K = scan.nextInt(); // 순위를 알고 싶은 국가
        int[][] medals = new int[N][4];

        for (int i = 0; i < N; i++) {
            medals[i][0] = scan.nextInt(); // 국가 번호
            medals[i][1] = scan.nextInt(); // 금메달 수
            medals[i][2] = scan.nextInt(); // 은메달 수
            medals[i][3] = scan.nextInt(); // 동메달 수
        }

        // 메달 정렬: 금 > 은 > 동
        Arrays.sort(medals, (a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1]; // 금메달 내림차순
            if (b[2] != a[2]) return b[2] - a[2]; // 은메달 내림차순
            return b[3] - a[3]; // 동메달 내림차순
        });

        int lastRank = 1; // 현재 순위
        for (int i = 0; i < N; i++) {
            // 첫 번째 국가를 제외하고, 이전 국가와 메달 비교
            if (i > 0) {
                boolean 동일_메달 = (medals[i - 1][1] == medals[i][1] &&
                                    medals[i - 1][2] == medals[i][2] &&
                                    medals[i - 1][3] == medals[i][3]);
                if (!동일_메달) {
                    lastRank = i + 1; // 동일하지 않으면 순위 증가
                }
            }

            // K번 국가의 순위 출력 후 종료
            if (medals[i][0] == K) {
                System.out.println(lastRank);
                return;
            }
        }
    }
}
