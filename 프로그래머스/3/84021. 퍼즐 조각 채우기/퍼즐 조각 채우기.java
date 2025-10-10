import java.util.*;

class Solution {
    
    /** 
        1. game_board에서 0번으로 구성된 퍼즐 조각을 찾는다.
        2. 1번에서 찾은 조각을 table에서 찾는다.
            - 회전 가능 -> 이걸 못하겠는데..
        3. 찾았으면 table에 0으로 표시한다.
    */
    public int solution(int[][] game_board, int[][] table) {
        int 맞춘_수 = 0;
        
        List<Model> 보드_모델 = new ArrayList<>();
        
        boolean[][] visited1 = new boolean[game_board.length][game_board[0].length];
        for(int i = 0; i < game_board.length; i++) {
            for(int j = 0; j < game_board[0].length; j++) {
                // 보드 판은 빈칸(0)으로 도형 만들기
                if(!visited1[i][j] && game_board[i][j] == 0) {
                    Model 완성된_모델 = bfs(i, j, game_board, visited1, 0);
                    보드_모델.add(완성된_모델);
                }
            }
        }
        
        List<Model> 테이블_모델 = new ArrayList<>();
        
        boolean[][] visited2 = new boolean[table.length][table[0].length];
        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table[0].length; j++) {
                // 테이블은 채원진 칸(1)으로 도형 만들기
                if(!visited2[i][j] && table[i][j] == 1) {
                    Model 완성된_모델 = bfs(i, j, table, visited2, 1);
                    테이블_모델.add(완성된_모델);
                }
            }
        }
        
        for(Model 모델1 : 보드_모델) {
            for(int i = 0; i < 테이블_모델.size(); i++) {
                if(모델1.isFit(테이블_모델.get(i))) {
                    맞춘_수 += 모델1.coordinates.size();
                    테이블_모델.remove(i);
                    break;
                }
            }
        }
        
        return 맞춘_수;
    }
    
    Model bfs(int row, int col, int[][] 게임_보드판, boolean[][] 방문_여부, int 연결할_숫자) {
        Model 완성된_모델 = new Model();
        완성된_모델.add(col, row); // 좌표는 거꾸로 대입
        
        방문_여부[row][col] = true; // 방문 표시
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            int cr = poll[0];
            int cc = poll[1];
            
            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(
                    nr >= 0 && nr <= 게임_보드판.length - 1 &&
                    nc >= 0 && nc <= 게임_보드판[0].length - 1 &&
                    !방문_여부[nr][nc] && 게임_보드판[nr][nc] == 연결할_숫자) {
                    완성된_모델.add(nc, nr); // 좌표는 거꾸로 대입
                    방문_여부[nr][nc] = true; // 방문 표시
                    
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        
        
        return 완성된_모델;
    }
}

class Model {
    List<Coordinate> coordinates;
    
    Model() {
        this.coordinates = new ArrayList<>();
    }
    
    void add(int x, int y) {
        Coordinate coordinate = new Coordinate(x, y);
        coordinates.add(coordinate);
    }
    
    boolean isFit(Model other) {
        // 좌표 수량 맞는지 확인
        if(coordinates.size() != other.coordinates.size()) {
            return false;
        }
        
        // 회전 전 맞는지 확인, 기준 점 동일하게~ 
        if(요소_같음_확인(other)) {
            return true;
        }
                
        // 회전해도 맞는지 확인, 90도, 180도, 270도
        // 90도 회전 방법: (x, y) -> (y, -x)
        회전_90도();
        if(요소_같음_확인(other)) {
            return true;
        }
        
        회전_90도();
        if(요소_같음_확인(other)) {
            return true;
        }
        
        회전_90도();
        if(요소_같음_확인(other)) {
            return true;
        }
        
        return false;
    }
    
    void 회전_90도() {
        for(Coordinate c : coordinates) {
            int 기존_x좌표 = c.getX();
            int 기존_y좌표 = c.getY();
            
            c.setCoordinate(기존_y좌표, -기존_x좌표);
        }
        
        기준점_정렬();
    }
    
    void 기준점_정렬() {   
        int 최소_x값 = Integer.MAX_VALUE;
        int 최소_y값 = Integer.MAX_VALUE;
        
        for(Coordinate c : coordinates) {
            최소_x값 = Math.min(최소_x값, c.x);
            최소_y값 = Math.min(최소_y값, c.y);
        }
        
        for(Coordinate c : coordinates) {
            c.setCoordinate(c.getX() - 최소_x값, c.getY() - 최소_y값);
        }
    }
    
    boolean 요소_같음_확인(Model target) {
        this.기준점_정렬();
        target.기준점_정렬();
        
        Collections.sort(this.coordinates, (a, b) -> {
            if(a.x == b.x) {
                return a.y - b.y;
            }
            return a.x - b.x;
        });
        
        Collections.sort(target.coordinates, (a, b) -> {
            if(a.x == b.x) {
                return a.y - b.y;
            }
            return a.x - b.x;
        });
        
        boolean 모두_같음 = true;
        for(int i = 0; i < this.coordinates.size(); i++) {
            Coordinate 원본 = this.coordinates.get(i);
            Coordinate 대상 = target.coordinates.get(i);
            
            if(원본.x != 대상.x) {
                모두_같음 = false;
                break;
            }
            if(원본.y != 대상.y) {
                모두_같음 = false;
                break;
            }
        }
        
        return 모두_같음;
    }
}

class Coordinate {
    int x;
    int y;
    
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    int getX() {
        return this.x;
    }
    
    int getY() {
        return this.y;
    }
    
    void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}