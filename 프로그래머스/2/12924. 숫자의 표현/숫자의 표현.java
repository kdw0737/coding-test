class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i =1; i<=n; i++){
            int sum = i;
            int num = i+1;
            while(true){
                if(sum > n){
                    break;
                }
                if(sum == n){
                    answer++;
                }
                sum+=num;
                num++;
            }
        }
        return answer;
    }
}