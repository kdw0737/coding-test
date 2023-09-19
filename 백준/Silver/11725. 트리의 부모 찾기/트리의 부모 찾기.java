import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> list[];
    static boolean visited[];
    static int N;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        list = new ArrayList[N + 1];
        result = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);
        for (int i = 2; i < N + 1; i++) {
            System.out.println(result[i]);
        }
    }

    public static void dfs(int idx) {
        visited[idx] = true;
        for (int n : list[idx]) {
            if (!visited[n]) {
                visited[n] = true;
                dfs(n);
                result[n] = idx;
            }
        }
    }
}