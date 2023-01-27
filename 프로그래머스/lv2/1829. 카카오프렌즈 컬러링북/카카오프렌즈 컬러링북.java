import java.util.*;
class Solution {
    static boolean[][] visited;
    static int area=0;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int width;
    static int height;
    public int[] solution(int m, int n, int[][] picture){
        width = n;
        height = m;
        int maxOfArea =Integer.MIN_VALUE;
        int countOfArea = 0;
        visited = new boolean[m][n];
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                area =0;
                if(!visited[i][j] && picture[i][j]!=0){
                    dfs(i,j,picture);
                    maxOfArea = Math.max(area,maxOfArea);
                    countOfArea++;
                }
            }
        }
        int[] result = new int[] {countOfArea,maxOfArea};
        return result;
    }
    private static void dfs(int y, int x, int[][] graph){
        visited[y][x] = true;
        area++;
        for(int i =0; i<4; i++){
            if(y+dy[i]>=0 && y+dy[i]<height && x+dx[i]>=0 && x+dx[i]<width){
                if(!visited[y+dy[i]][x+dx[i]] && graph[y+dy[i]][x+dx[i]] == graph[y][x]){
                    dfs(y+dy[i],x+dx[i],graph);
                }
            }
        }
    }
}