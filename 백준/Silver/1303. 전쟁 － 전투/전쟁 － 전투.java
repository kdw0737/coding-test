import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static String[][] arr;
    static boolean[][] visited;
    static int atkB = 0; static int atkW = 0;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new String[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = bf.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = str[j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    sum = 0;
                    dfs(i, j);
                    if (arr[i][j].equals("W")) {
                        atkW += sum * sum;
                    } else {
                        atkB += sum * sum;
                    }
                }
            }
        }
        System.out.println(atkW + " " + atkB);
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        sum ++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < N && ny >= 0 && nx < M && nx >= 0) {
                if (!visited[ny][nx] && arr[ny][nx].equals(arr[y][x])) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
