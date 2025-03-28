import java.util.*;
class Solution {
    int result = 0;
    public int solution(int[] number) {
        // 삼총사를 만들 수 있는 방법의 수 return 
        
        dfs(number, 0, 0, 0);
        return result;
    }
    
    public void dfs(int[] arr, int idx, int depth, int sum){
        if(depth == 3){
            if(sum == 0) result ++;
            return;
        }
        
        for(int i = idx; i < arr.length; i++){
            dfs(arr, i +1 , depth + 1, sum + arr[i]);
        }
    }
}