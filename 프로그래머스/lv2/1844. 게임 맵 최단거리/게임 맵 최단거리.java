import java.util.*;
class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public int solution(int[][] maps) {
        bfs(maps);
        if(maps[maps.length-1][maps[maps.length-1].length-1] == 1){
            return -1;
        }else{
            return maps[maps.length-1][maps[0].length-1];
        }
    }
    
    public void bfs(int[][] maps){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0});
        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int i =0; i<4; i++){
                int newX = cur[1]+dx[i];
                int newY = cur[0]+dy[i];
                if(newY>=0 && newY<maps.length && newX>=0 && newX<maps[0].length){
                    if(maps[newY][newX] == 1){
                        maps[newY][newX] = maps[cur[0]][cur[1]] +1;
                        que.add(new int[]{newY,newX});                 
                    }
                }
            }
        }
    }
}