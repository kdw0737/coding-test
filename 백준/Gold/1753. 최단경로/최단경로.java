import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static List<Node>[] arr;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(bf.readLine());

		arr = new ArrayList[v + 1];
		dist = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			arr[i] = new ArrayList<>();
			dist[i] = INF;
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			arr[a].add(new Node(b, w));
		}

		dijkstra(start);

		for (int i = 1; i <= v; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			if(dist[node.v] > node.w) {
				continue;
			}

			for (Node nextNode : arr[node.v]) {
				int newDist = dist[node.v] + nextNode.w;

				if(newDist < dist[nextNode.v]) {
					dist[nextNode.v] = newDist;
					pq.add(new Node(nextNode.v, newDist));
				}
			}
		}
	}

	static class Node {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}
