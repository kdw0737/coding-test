import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int height = Integer.parseInt(st.nextToken());
        int cur = Integer.parseInt(st.nextToken());
        int office = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int[] visited = new int[height + 1];
        if (office > cur && up == 0) {
            System.out.println("use the stairs");
        } else if (office < cur && down == 0) {
            System.out.println("use the stairs");
        } else {
            int result = bfs(height, cur, office, up, down,visited);
            if (result == -1) {
                System.out.println("use the stairs");
            } else {
                System.out.println(result-1);
            }
        }
    }

    private static int bfs(int height, int cur, int office, int up, int down, int[] visited) {
        Queue<Integer> que = new LinkedList<>();
        visited[cur] = 1;
        que.add(cur);
        while (!que.isEmpty()) {
            int tmp = que.poll();
            if (tmp == office) {
                return visited[tmp];
            }
            if (tmp + up <= height && visited[tmp+up]==0) {
                que.add(tmp + up);
                visited[tmp + up] = visited[tmp] + 1;
            }
            if (tmp - down > 0 && visited[tmp - down]==0) {
                que.add(tmp - down);
                visited[tmp - down] = visited[tmp] + 1;
            }
        }
        return -1;
    }
}