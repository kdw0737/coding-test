import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int from,to,cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        int[] parent = new int[N + 1];
        long result = 0;
        for (int i = 0; i < N; i++) {
            String[] arr = bf.readLine().split(" ");
            for(int j =0; j<N; j++){
                if(i==j)
                    continue;
                pq.add(new Node(i, j, Integer.parseInt(arr[j])));
            }
        }
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        while (!pq.isEmpty()) {
    Node node = pq.poll();
    if (!isSameParent(parent, node.from, node.to)) {
        union(parent, node.from, node.to);
        result += node.cost;
    }
}
        System.out.println(result);
    }

    public static int find(int[] parent, int idx) {
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