import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // 행 크기
        int M = scan.nextInt(); // 열 크기
        scan.nextLine();

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 방문 여부 배열: [row][col][벽 부순 여부]
        boolean[][][] visited = new boolean[N][M][2];

        // BFS 큐: [row, col, 이동 거리, 벽 부순 여부]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1, 0}); // 시작 위치
        visited[0][0][0] = true;

        // 방향 배열
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        // BFS 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cRow = current[0];
            int cCol = current[1];
            int distance = current[2];
            int brokenWall = current[3];

            // 도착 지점에 도달한 경우
            if (cRow == N - 1 && cCol == M - 1) {
                System.out.println(distance);
                return;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nRow = cRow + dRow[i];
                int nCol = cCol + dCol[i];

                // 맵 범위 내인지 확인
                if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < M) {
                    // 이동 가능: 벽이 아닌 경우
                    if (map[nRow][nCol] == 0 && !visited[nRow][nCol][brokenWall]) {
                        visited[nRow][nCol][brokenWall] = true;
                        queue.offer(new int[]{nRow, nCol, distance + 1, brokenWall});
                    }
                    // 벽을 부수고 이동: 아직 벽을 부수지 않은 경우
                    else if (map[nRow][nCol] == 1 && brokenWall == 0 && !visited[nRow][nCol][1]) {
                        visited[nRow][nCol][1] = true;
                        queue.offer(new int[]{nRow, nCol, distance + 1, 1});
                    }
                }
            }
        }

        // 도착하지 못한 경우
        System.out.println(-1);
    }
}
