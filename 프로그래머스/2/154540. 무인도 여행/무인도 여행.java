import java.util.*;
class Solution {
    int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] visited;
    int y, x, cnt;
    public int[] solution(String[] maps) {
        // 지낼 수 있는 날짜들을 오름차순으로 정리
        y = maps.length;
        x = maps[0].length();
        visited = new boolean[y][x];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i =0; i<y; i++){
            for(int j =0; j<x; j++){
                if(!visited[i][j] && maps[i].charAt(j) != 'X'){
                    cnt = Integer.parseInt(String.valueOf(maps[i].charAt(j)));
                    visited[i][j] = true;
                    dfs(maps,i,j);
                    list.add(cnt);
                }
            }
        }
        
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(list);
        
        int[] result = new int[list.size()];
        
        for(int i =0; i< list.size(); i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
    
    public void dfs(String[] maps, int cy, int cx){
        for(int i =0; i<4; i++){
            int ny = cy + delta[i][0];
            int nx = cx + delta[i][1];
            
            if(isIn(ny,nx) && !visited[ny][nx] && maps[ny].charAt(nx) != 'X'){
                visited[ny][nx] = true;
                cnt += Integer.parseInt(String.valueOf(maps[ny].charAt(nx)));
                dfs(maps,ny,nx);
            }
        }
    }
    
    public boolean isIn(int cy, int cx){
        return 0<=cy && cy<y && 0<=cx && cx<x;
    }
}