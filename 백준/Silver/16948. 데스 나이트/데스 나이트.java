import java.io.*;
import java.util.*;

public class Main {
    static int dx[] = {-1, 1, -2, 2, -1,1};
    static int dy[] = {-2,-2, 0, 0, 2, 2};
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());
        visited[startY][startX] = true;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startY, startX, 0));
        while (!que.isEmpty()) {
            Node point = que.poll();
            if (point.y == endY && point.x == endX) {
                System.out.println(point.cnt);
                System.exit(0);
            }
            for (int i = 0; i < 6; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];
                if (ny < N && ny >= 0 && nx < N && nx >= 0) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        que.add(new Node(ny, nx, point.cnt + 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static class Node {
        int x;
        int y;
        int cnt;

        public Node(int y, int x, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}