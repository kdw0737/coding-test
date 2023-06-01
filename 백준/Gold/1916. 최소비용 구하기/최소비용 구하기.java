import java.io.*;
import java.util.*;

public class Main {
    static int city, bus;
    static boolean[] visited ;
    static long[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        city = Integer.parseInt(bf.readLine());
        bus = Integer.parseInt(bf.readLine());
        long[][] map = new long[city][city];
        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                if (i == j) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < bus; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(cost, map[a][b]);
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int destination = Integer.parseInt(st.nextToken()) - 1;
        dist = map[start].clone();
        visited = new boolean[city];
        visited[start] = true;
        for (int i = 1; i < city; i++) {
            int idx = selectMinCost();
            visited[idx] = true;
            for (int j = 0; j < city; j++) {
                if (!visited[j]) {
                    dist[j] = Math.min(dist[j], dist[idx] + map[idx][j]);
                }
            }
        }
        System.out.println(dist[destination]);
    }

    public static int selectMinCost() {
        int idx = 0;
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < city; i++) {
            if (visited[i]) {
                continue;
            }
            if (min > dist[i]) {
                min = dist[i];
                idx = i;
            }
        }
        return idx;
    }
}