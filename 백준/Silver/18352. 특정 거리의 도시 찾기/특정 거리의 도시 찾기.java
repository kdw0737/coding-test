import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int city = Integer.parseInt(st.nextToken());
        int road = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] dist = new int[300001];

        for (int i = 0; i <= city; i++) {
            list.add(new ArrayList<Integer>());
            dist[i] = -1; // 최단거리 -1로 초기화
        }

        for (int i = 0; i < road; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        dist[start] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    que.add(next);
                }
            }
        }

        boolean check = true;
        for (int i = 1; i <= city; i++) {
            if (dist[i] == target) {
                System.out.println(i);
                check = false;
            }
        }

        if (check) {
            System.out.println(-1);
        }
    }
}
