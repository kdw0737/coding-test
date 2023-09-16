import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static int N;
    static boolean[] visited;
    static int end;
    static int start;
    static class Node {
        int idx;
        int count;

        public Node(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;
        bfs(start);
    }

    public static  void bfs(int start) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(start, 1));
        while (!que.isEmpty()) {
            Node node = que.poll();
            if (!visited[node.idx]) {
                visited[node.idx] = true;
                if (Math.abs(end - node.idx) % arr[node.idx] == 0) {
                    System.out.println(node.count);
                    return;
                } else {
                    int tmp = 1;
                    boolean check = true;
                    while (true) {
                        check = false;
                        if (node.idx + (arr[node.idx] * tmp) < N) {
                            que.add(new Node(node.idx + (arr[node.idx] * tmp), node.count + 1));
                            check = true;
                        }
                        if (node.idx - (arr[node.idx] * tmp) >= 0) {
                            que.add(new Node(node.idx - (arr[node.idx] * tmp), node.count + 1));
                            check = true;
                        }
                        tmp++;
                        if (!check) {
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
        return;
    }
}