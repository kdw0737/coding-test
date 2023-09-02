import java.util.*;
import java.io.*;

public class Main {
    static int N,chicken;
    static int[][] map;
    static ArrayList<Node> chickenList = new ArrayList<>();
    static ArrayList<Node> houseList = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        chicken = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houseList.add(new Node(i, j));
                }
                if (map[i][j] == 2) {
                    chickenList.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[chickenList.size()];
        dfs(0, 0);
        System.out.println(result);
    }

    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void dfs(int idx, int depth) {
        if (depth == chicken) {
            int dist = 0;
            for (int i = 0; i < houseList.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for (int j = 0; j < chickenList.size(); j++) {
                    if (visited[j]) {
                        int tmp = Math.abs(houseList.get(i).x - chickenList.get(j).x)
                                + Math.abs(houseList.get(i).y - chickenList.get(j).y);
                        sum = Math.min(sum, tmp);
                    }
                }
                dist += sum;
            }
            result = Math.min(dist, result);
            return;
        }
        for (int i = idx; i < chickenList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}