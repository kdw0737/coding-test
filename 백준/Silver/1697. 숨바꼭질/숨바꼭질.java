import java.io.*;
import java.util.*;

public class Main {
    static int[] visited = new int[100001];
    static int destination;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());
        if (start > destination) {
            System.out.println(start - destination);
            return;
        }
        if (start == destination) {
            System.out.println(0);
            return;
        }
        System.out.println(bfs(start));
    }

    static int bfs(int num) {
        Queue<Integer> que = new LinkedList<>();
        que.add(num);
        while (!que.isEmpty()) {
            int tmp = que.poll();
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = tmp + 1;
                } else if (i == 1) {
                    next = tmp - 1;
                } else {
                    next = tmp * 2;
                }
                if (next == destination) {
                    return visited[tmp]+1;
                }
                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    que.add(next);
                    visited[next] = visited[tmp] + 1;
                }
            }
        }
        return 0;
    }
}