import java.util.*;
class Solution {
    int n;
    int[] weak;
    int[] dist;
    int result = Integer.MAX_VALUE;
    public int solution(int N, int[] Weak, int[] Dist) {
        // 보내야하는 친구 수의 최소값 return
        n = N; weak = Weak; dist = Dist;
        Arrays.sort(dist);
        
        for(int i =0; i< weak.length; i++){
            boolean[] visited = new boolean[weak.length];
            rotation(1, i, 0);
        }
        
        if(result == Integer.MAX_VALUE) return -1;
        
        return result;
    }
    
    public void rotation(int cnt, int pos, int visited) {
        if(cnt > dist.length) return;
        if(cnt >= result) return;
        
        for(int i =0; i< weak.length; i++) {
            int nextPos = (pos + i) % weak.length; 
            int diff = weak[nextPos] - weak[pos];

            if(nextPos < pos) diff += n;
        
            if (diff > dist[dist.length - cnt]) break;
        
            visited |= 1 << nextPos;
        }
        
        if(visited == (1 << weak.length) - 1){
            result = cnt;
            return;
        }
        
        for(int i =0; i<weak.length; i++){
            if((visited & (1 << i)) != 0) continue;
            
            rotation(cnt + 1, i, visited);
        }
    }
}