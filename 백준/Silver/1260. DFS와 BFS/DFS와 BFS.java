import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] graph;
    static int node;
    static int vertex;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        node = Integer.parseInt(st.nextToken());
        vertex = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        graph = new int[node+1][node+1];
        visited = new boolean[node+1];
        for (int i = 0; i < vertex; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph[n][m] = 1;
            graph[m][n] = 1;
        }
        dfs(start);
        System.out.println();
        visited = new boolean[node+1];
        bfs(start);
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        System.out.print(idx+" ");
        for (int i = 1; i <= node; i++) {
            if (graph[idx][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int idx) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(idx);
        visited[idx] = true;
        System.out.print(idx+" ");
        while (!que.isEmpty()) {
            int tmp = que.poll();
            for (int i = 1; i <= node; i++) {
                if (!visited[i] && graph[tmp][i] == 1) {
                    que.offer(i);
                    visited[i] = true;
                    System.out.print(i+" ");
                }
            }
        }
    }
}