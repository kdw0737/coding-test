import java.io.*;
import java.util.*;

public class Main {
    static int[][] visited;
    static int height;
    static int width;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static String[][] graph;
    static int min = Integer.MIN_VALUE;
    static Queue<int[]> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        graph = new String[height][width];
        for (int i = 0; i < height; i++) {
            String[] arr = bf.readLine().split("");
            for (int j = 0; j < width; j++) {
                graph[i][j] = arr[j];
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (graph[i][j].equals("L")) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(min+1);
    }

    private static void bfs(int y, int x) {
        visited = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                visited[i][j] = -1;
            }
        }
        visited[y][x] = 0;
        que.offer(new int[]{y, x});
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            for (int i = 0; i < 4; i++) {
                if (tmp[0] + dy[i] >= 0 && tmp[0] + dy[i] < height && tmp[1] + dx[i] >= 0 && tmp[1] + dx[i] < width) {
                    if (visited[tmp[0] + dy[i]][tmp[1] + dx[i]] == -1 && graph[tmp[0] + dy[i]][tmp[1] + dx[i]].equals("L")) {
                        visited[tmp[0]+dy[i]][tmp[1]+dx[i]] = visited[tmp[0]][tmp[1]] + 1;
                        que.offer(new int[]{tmp[0] + dy[i], tmp[1] + dx[i]});
                        min = Math.max(min, visited[tmp[0]][tmp[1]]);
                    }
                }
            }
        }
    }
}