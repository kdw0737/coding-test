class Solution {
    public int solution(int[][] triangle) {
        int[] dp = new int[triangle.length];
        int[][] sum = new int[triangle.length][triangle.length];
        sum[0][0] = triangle[0][0];
        for(int i =1; i<triangle.length; i++){
            sum[i][0]=triangle[i][0]+sum[i-1][0];
            sum[i][triangle[i].length-1]=triangle[i][triangle[i].length-1]+sum[i-1][triangle[i-1].length-1];
            for(int j =1; j<i; j++){
                sum[i][j]=Math.max(triangle[i][j]+sum[i-1][j-1],triangle[i][j]+sum[i-1][j]);
            }
        }
        int answer =0;
        for(int n : sum[triangle.length-1]){
            if(answer<n)
                answer =n;
        }
        return answer;
    }
}