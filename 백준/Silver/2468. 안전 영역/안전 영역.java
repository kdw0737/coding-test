import java.io.*;
import java.util.*;

public class Main {
    static int cnt=1; //아무 지역도 물에 잠기지 않을 수도 있다.(최소 안전지대 1)
    static int tmp=0; //dfs돌면서 안전지역 카운트
    static int maxRain = Integer.MIN_VALUE;
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static boolean[][] isSubmerged;
    static int[] x = {0,0,1,-1};
    static int[] y = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        graph = new int[N][N];
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j =0; j<N; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                if(maxRain<graph[i][j])
                    maxRain=graph[i][j];
            }
        }
        for(int k =1; k<maxRain; k++){
            tmp =0;
            isSubmerged = new boolean[N][N];
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j =0; j<N; j++){
                    if(graph[i][j]<=k)
                        isSubmerged[i][j]=true;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && !isSubmerged[i][j]){
                        dfs(i, j);
                        tmp++;
                    }
                }
            }
            cnt=Math.max(cnt,tmp);
        }
        System.out.println(cnt);
    }

    private static void dfs(int i, int j){
        visited[i][j] = true;
        for(int n =0; n<4; n++){
            if(j+x[n]>=0 && j+x[n]<N && i+y[n]>=0 && i+y[n]<N){
                if(!visited[i+y[n]][j+x[n]] && !isSubmerged[i+y[n]][j+x[n]])
                    dfs(i+y[n],j+x[n]);
            }
        }
    }
}