import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        visited = new boolean[N + 1];
        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        visited[1] = true;
        int count =0;
        for (int i = 2; i < N + 1; i++) {
                if (graph[1][i] == 1) {
                    dfs(i,0);
            }
        }
        for (int i = 2; i < visited.length; i++) {
            if (visited[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int idx, int depth) {
        if (depth == 2) {
            return;
        }
        visited[idx] = true;
        for (int i = 1; i < N + 1; i++) {
            if(graph[idx][i] ==1) {
                dfs(i, depth + 1);
            }
        }
    }
}
