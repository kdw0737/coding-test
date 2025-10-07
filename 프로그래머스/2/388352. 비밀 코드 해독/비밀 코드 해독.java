import java.util.*;

class Solution {
    static int result = 0;
    public int solution(int n, int[][] q, int[] ans) {
        // 1 ~ n 까지 서로 다른 정수 5개 오름차순
        int[] arr= new int[5];
        comb(n,q,ans,1,new ArrayList<>());
        
        return result;
    }
    
    public void comb(int n, int[][] q, int[] ans, int start, List<Integer> list){
        if(list.size() == 5){
            isPossible(q, ans, list);
            return;
        }
        
        for(int i = start; i <= n; i++){
            list.add(i);
            comb(n,q,ans,i+1,list);
            list.remove(list.size() - 1);
        }
    } 
    
    public void isPossible(int[][] q, int[] ans, List<Integer> list){
        int cnt = 0;
        boolean check = true;
        
        for(int i =0 ; i< ans.length; i++){
            int[] arr = q[i];
            cnt = 0;
            
            for(int n : arr){
                if(list.contains(n)){
                    cnt++;
                }
            }
            
            if(ans[i] != cnt){
                check = false;
                break;
            }
        }
        
        if(check){
            result++;
        }
    }
}