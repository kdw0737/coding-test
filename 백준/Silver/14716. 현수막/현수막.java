import java.util.*;
import java.io.*;

public class Main {
    static int col, row;
    static int[][] arr;
    static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dy = {1, -1, 0, 1, -1, 0, 1, -1};
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static public void bfs(int y, int x) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{y, x});
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            for (int i = 0; i < 8; i++) {
                int ny = tmp[0] + dy[i];
                int nx = tmp[1] + dx[i];
                if (ny >= 0 && ny < row && nx >= 0 && nx < col) {
                    if (arr[ny][nx] == 1) {
                        arr[ny][nx] = 0;
                        que.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
