import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int depth, int cost) {
        if (depth == 3) {
            answer = Math.min(answer, cost);
            return;
        }
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (!visited[i][j] && !checkVisited(i, j)) {
                    visited[i][j] = true;
                    addVisited(i, j);
                    dfs(depth + 1, cost + calcSum(i, j));
                    clearVisited(i, j);
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void clearVisited(int y, int x) {
        for (int i = 0; i < 4; i++) {
            visited[y + dy[i]][x + dx[i]] = false;
        }
    }

    public static boolean checkVisited(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (visited[ny][nx]) {
                return true;
            }
        }
        return false;
    }

    public static int calcSum(int y, int x) {
        int sum = arr[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            sum += arr[ny][nx];
        }
        return sum;
    }

    public static void addVisited(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            visited[ny][nx] = true;
        }
    }
}
