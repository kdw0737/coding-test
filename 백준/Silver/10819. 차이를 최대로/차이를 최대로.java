import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int N;
    static int[] arr;
    static int[] changed_arr;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        changed_arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];
        dfs( 0);
        System.out.println(result);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(changed_arr[i] - changed_arr[i + 1]);
            }
            result = Math.max(sum, result);
            return;
        }
        for (int i = 0; i < N ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                changed_arr[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
