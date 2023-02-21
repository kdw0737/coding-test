import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int day =0;
    static int width; static int height;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Tomato> que = new LinkedList<>();
    static class Tomato {
        private int y;
        private int x;

        public Tomato(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        graph = new int[height][width];
        for (int i = 0; i < height ; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < width; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    que.add(new Tomato(i, j));
                }
            }
        }
        bfs();
        System.out.println(day-1);
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            Tomato tomato = que.poll();
            for (int i = 0; i < 4; i++) {
                int newX = tomato.getX() + dx[i];
                int newY = tomato.getY() + dy[i];
                if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
                    if (graph[newY][newX] == 0) {
                        que.add(new Tomato(newY, newX));
                        graph[newY][newX] = graph[tomato.getY()][tomato.getX()] + 1;
                    }
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                day = Math.max(day, graph[i][j]);
                if (graph[i][j] == 0) {
                    day = 0;
                    return ;
                }
            }
        }
    }
}