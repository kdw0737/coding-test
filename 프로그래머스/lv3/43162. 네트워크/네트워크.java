import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i =0; i<n; i++){
            if(!visited[i]){
                dfs(n,computers,i);
                answer++;
            }
        }
        return answer;
    }
    
    private static void dfs(int n , int[][] computers, int idx){
        if(visited[idx]){
            return;
        }
        visited[idx] = true;
        for(int i =0; i<n; i++){
            if(computers[idx][i] == 1){
                dfs(n,computers,i);
            }
        }
    }
}