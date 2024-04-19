import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        arr = new int[N][2];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 1, 0);
        System.out.println(min);
    }

    public static void dfs(int depth, int sourSum, int bitterSum) {
        if (depth > 0) {
            min = Math.min(Math.abs(sourSum - bitterSum), min);
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i]= true;
                dfs(depth + 1, sourSum * arr[i][0], bitterSum + arr[i][1]);
                visited[i]= false;
            }
        }
    }
}
