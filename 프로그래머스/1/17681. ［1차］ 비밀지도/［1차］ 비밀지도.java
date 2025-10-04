class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[][] 지도 = new String[n][n];
        
        for(int i = 0; i <= arr1.length - 1; i++) {
            String[] 분리 = String.format("%"+ n + "s", Integer.toBinaryString(arr1[i]))
                .replaceAll(" ","0")
                .split("");
            
            for(int j = 0; j <= 분리.length -1; j++) {
                if(분리[j].equals("1")) {
                    지도[i][j] = "#";
                }
            }
        }
        
        for(int i = 0; i <= arr2.length - 1; i++) {
            String[] 분리 = String.format("%"+ n + "s", Integer.toBinaryString(arr2[i]))
                .replaceAll(" ","0")
                .split("");
            
            for(int j = 0; j <= 분리.length -1; j++) {
                if(분리[j].equals("1")) {
                    지도[i][j] = "#";
                }
            }
        }
        
        String[] 답 = new String[n];
        for(int i = 0; i <= 지도.length - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j <= 지도[0].length - 1; j++) {
                String 지도_값 = 지도[i][j];
                if(지도_값 == null) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            답[i] = sb.toString();
        }
        
        return 답;
    }
}