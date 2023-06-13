import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int from; int to; int cost;

        Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Node(from, to, cost));
        }
        int[] parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < E; i++) {
            Node node = pq.poll();
            if (!isSameParent(parent, node.from, node.to)) {
                union(parent, node.from, node.to);
                result += node.cost;
            }
        }
        System.out.println(result);
    }

    public static int find (int[] parent, int idx) {
        if (parent[idx] == idx) {
            return idx;
        }
        return parent[idx] = find(parent, parent[idx]);
    }

    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static boolean isSameParent(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}