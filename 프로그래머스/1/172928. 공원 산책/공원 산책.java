class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 1. 시작점 찾기
        // 2. 이동하기
        //  - routes 순회하기
        //      - 1) park를 벗어나진 않는지
        //      - 2) 이동 경로에 장애물은 없는지
        
        int[] 위치 = new int[2];
        
        String[][] 공원 = new String[park.length][park[0].length()];
        
        for(int k = 0; k < park.length; k++) {
            String[] 문자열_쪼갬 = park[k].split("");
            for(int i = 0; i < 문자열_쪼갬.length; i++) {
                공원[k][i] = 문자열_쪼갬[i];
                
                if(문자열_쪼갬[i].equals("S")) {
                    위치[0] = k;
                    위치[1] = i;
                }
            }
        }
        
        for(String route : routes) {
            String[] 분해 = route.split(" ");
            
            String 방향 = 분해[0];
            int 거리 = Integer.parseInt(분해[1]);
            
            // 위
            if(방향.equals("N")) {
                int 새로운_위치 = 위치[0] - 거리;
                
                // 공원을 벗어나지 않았는지
                if(!(새로운_위치 >= 0 && 새로운_위치 <= 공원.length - 1)) {
                    continue;
                }
                
                // 중간에 장애물은 없는지
                boolean 장애물_여부 = false;
                for(int i = 1; i <= 거리; i++) {
                    if(공원[위치[0] - i][위치[1]].equals("X")) {
                        장애물_여부 = true;
                        break;
                    }
                }
                
                if(!장애물_여부) {
                    위치[0] = 새로운_위치;
                }
            }
            // 아래
            else if(방향.equals("S")) {
                int 새로운_위치 = 위치[0] + 거리;
                
                // 공원을 벗어나지 않았는지
                if(!(새로운_위치 >= 0 && 새로운_위치 <= 공원.length - 1)) {
                    continue;
                }
                
                // 중간에 장애물은 없는지
                boolean 장애물_여부 = false;
                for(int i = 1; i <= 거리; i++) {
                    if(공원[위치[0] + i][위치[1]].equals("X")) {
                        장애물_여부 = true;
                        break;
                    }
                }
                
                if(!장애물_여부) {
                    위치[0] = 새로운_위치;
                }
            }
            // 좌
            else if (방향.equals("W")) {
                int 새로운_위치 = 위치[1] - 거리;
                
                // 공원을 벗어나지 않았는지
                if(!(새로운_위치 >= 0 && 새로운_위치 <= 공원[0].length - 1)) {
                    continue;
                }
                
                // 중간에 장애물은 없는지
                boolean 장애물_여부 = false;
                for(int i = 1; i <= 거리; i++) {
                    if(공원[위치[0]][위치[1] - i].equals("X")) {
                        장애물_여부 = true;
                        break;
                    }
                }
                
                if(!장애물_여부) {
                    위치[1] = 새로운_위치;
                }
            }
            // 우
            else {
                int 새로운_위치 = 위치[1] + 거리;
                
                // 공원을 벗어나지 않았는지
                if(!(새로운_위치 >= 0 && 새로운_위치 <= 공원[0].length - 1)) {
                    continue;
                }
                
                // 중간에 장애물은 없는지
                boolean 장애물_여부 = false;
                for(int i = 1; i <= 거리; i++) {
                    if(공원[위치[0]][위치[1] + i].equals("X")) {
                        장애물_여부 = true;
                        break;
                    }
                }
                
                if(!장애물_여부) {
                    위치[1] = 새로운_위치;
                }
            }
        }
        return 위치;
    }
}