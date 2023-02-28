import java.io.*;
import java.util.*;

public class Main {
    static int node;
    static int vertex;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        node = Integer.parseInt(st.nextToken());
        vertex = Integer.parseInt(st.nextToken());
        int[][] graph = new int[node + 1][node + 1];
        for (int i = 0; i < vertex; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph[n][m] = 1;
            graph[m][n] = 1;
        }
        visited = new boolean[node+1];
        int result = 0;
        for (int i = 1; i < node + 1; i++) {
            if (!visited[i]) {
                dfs(graph,i);
                result ++;
            }
        }
        System.out.println(result);
    }

    static void dfs(int[][] graph, int idx) {
        if (visited[idx]) {
            return;
        }
        visited[idx] = true;
        for (int i = 1; i < node + 1; i++) {
            if (graph[idx][i] == 1 && !visited[i]) {
                dfs(graph, i);
            }
        }
    }
}