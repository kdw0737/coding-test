import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int v, e, x;
	static List<Node>[] list;
	static int[] dist;
	static int[] reverseDist;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		list = new ArrayList[v + 1];
		dist = new int[v + 1];
		reverseDist = new int[v + 1];

		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, w));
		}

		for (int i = 1; i <= v; i++) {
			Arrays.fill(dist, 999999999);
			Arrays.fill(reverseDist, 999999999);
			dijkstra(i, x);
			reverseDijksra(x, i);
			result = Math.max(dist[x] + reverseDist[i], result);
		}

		System.out.println(result);
	}

	public static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

		pq.add(new Node(start, 0));
		dist[start] = 0;

		while(!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.node] < cur.weight) {
				continue;
			}

			for (Node nextNode : list[cur.node]) {
				if(dist[cur.node] + nextNode.weight < dist[nextNode.node]) {
					dist[nextNode.node] = dist[cur.node] + nextNode.weight;
					pq.add(new Node(nextNode.node, dist[nextNode.node]));
				}
			}
		}
	}

	public static void reverseDijksra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

		pq.add(new Node(start, 0));
		reverseDist[start] = 0;

		while(!pq.isEmpty()) {
			Node cur = pq.poll();

			if (reverseDist[cur.node] < cur.weight) {
				continue;
			}

			for (Node nextNode : list[cur.node]) {
				if(reverseDist[cur.node] + nextNode.weight < reverseDist[nextNode.node]) {
					reverseDist[nextNode.node] = reverseDist[cur.node] + nextNode.weight;
					pq.add(new Node(nextNode.node, reverseDist[nextNode.node]));
				}
			}
		}
	}

	static class Node {
		int node;
		int weight;

		public Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}
}
