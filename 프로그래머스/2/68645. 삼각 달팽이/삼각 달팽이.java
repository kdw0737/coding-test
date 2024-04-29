class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int[] answer = new int[n*(n+1)/2];
        int x = 0;
        int y = -1;
        int num = 1;
        for(int i =0; i<n; i++){
            for(int j = i; j<n; j++){
                if(i%3 == 0){
                    y++;
                }else if( i%3 == 1){
                    x++;
                }else if( i%3 == 2){
                    x--;
                    y--;
                }
                arr[y][x] = num++;
            }
        }
        int idx =0;
        for(int i =0; i<n; i++){
            for(int j =0; j<=i; j++){
                answer[idx] = arr[i][j];
                idx++;
            }
        }
        return answer;
    }
}