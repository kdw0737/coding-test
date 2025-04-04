class Solution {
    public int solution(int[][] board, int[][] skills) {
        // type 1 : 공격 , 2 : 회복
        int y = board.length; 
        int x = board[0].length;
        int[][] prefixMap = new int[y+1][x+1];
        int result = 0;
        
        for(int[] skill : skills){
            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = skill[5];

            int effect = (type == 1) ? -degree : degree;

            // 누적 차이 배열 4군데 처리 (+=로 변경)
            prefixMap[r1][c1] += effect;
            prefixMap[r2 + 1][c1] -= effect;
            prefixMap[r1][c2 + 1] -= effect;
            prefixMap[r2 + 1][c2 + 1] += effect;
        }
        
        for(int i =0; i<y; i++){
            for(int j =0; j<x; j++){
                prefixMap[i][j+1] += prefixMap[i][j]; 
            }
        }
        
        for (int j = 0; j < x; j++) {         
            for (int i = 0; i < y; i++) {     
                prefixMap[i + 1][j] += prefixMap[i][j];
            }
        }

        
        for(int i =0; i<y; i++){
            for(int j =0; j<x; j++){
                board[i][j] += prefixMap[i][j];
                if(board[i][j] >= 1) result++;
            }
        }
        
        return result;
    }
}