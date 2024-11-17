import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(words, begin, target, 0, visited);
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }
    
    public static void dfs(String[] words, String cur, String target, int depth, boolean[] visited){
        if(cur.equals(target)){ // 현재 단어가 target과 일치하는 경우 
            min = Math.min(min, depth);
            return;
        }
        
        for(int i =0; i< words.length; i++){
            if(!visited[i]){
                if(isPossible(cur,words[i])){ // 한글자만 다른 단어인 경우
                    visited[i] = true;
                    dfs(words, words[i], target, depth+1, visited);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static boolean isPossible(String cur, String goal){ // 한글자만 다른지 체크 
        int cnt = 0;
        for(int i =0 ; i < cur.length(); i++){
            if(cur.charAt(i) != goal.charAt(i)) cnt++;
        }
        if(cnt == 1) return true;
        return false;
    }
}