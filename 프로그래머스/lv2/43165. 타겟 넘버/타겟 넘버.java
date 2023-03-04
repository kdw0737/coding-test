class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return answer;
    }
    
    private static void dfs(int[] num, int trgt, int idx, int sum){
        if(idx==num.length){
            if(sum==trgt)
                answer++;
            return;
        }
        dfs(num,trgt,idx+1,sum+num[idx]);
        dfs(num,trgt,idx+1,sum-num[idx]);
    }
}