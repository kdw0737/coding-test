import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static int w,h;
    static int[][] graph;
    static boolean[][] visited;
    static int[] x = {1,1,1,0,0,-1,-1,-1};
    static int[] y = {0,1,-1,1,-1,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0)
                break;
            cnt = 0;
            graph = new int[h][w];
            visited = new boolean[h][w];
            for(int i= 0; i<h; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j =0; j<w; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i =0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j]&& graph[i][j]==1){
                        dfs(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int height, int width){
        visited[height][width]=true;
        for(int i =0; i<8; i++){
            if(width+x[i]>=0 && width+x[i]<w && height+y[i]>=0 && height+y[i]<h){
                if(graph[height+y[i]][width+x[i]]==1 && !visited[height+y[i]][width+x[i]])
                    dfs(height+y[i],width+x[i]);
            }
        }
    }
}