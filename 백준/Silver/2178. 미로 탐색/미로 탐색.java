import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int height;
    static int width;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new int[height][width];
        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            String[] str = bf.readLine().split("");
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        bfs();
        System.out.println(map[height - 1][width - 1]);
    }

    private static void bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur[1] + dx[i];
                int newY = cur[0] + dy[i];
                if (newY >= 0 && newY < height && newX >= 0 && newX < width) {
                    if (map[newY][newX] != 0 && !visited[newY][newX]) {
                        map[newY][newX] = map[cur[0]][cur[1]] + 1;
                        que.add(new int[]{newY, newX});
                        visited[newY][newX] = true;
                    }
                }
            }
        }
    }
}
