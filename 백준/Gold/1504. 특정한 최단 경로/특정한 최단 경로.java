import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 200000000;
	static List<Node>[] graph;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, w));
			graph[b].add(new Node(a, w));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int[] distFrom1 = dijkstra(1);
		int[] distFromV1 = dijkstra(v1);
		int[] distFromV2 = dijkstra(v2);

		// 경로 1: 1 -> v1 -> v2 -> N
		long path1 = (long)distFrom1[v1] + distFromV1[v2] + distFromV2[N];

		// 경로 2: 1 -> v2 -> v1 -> N
		long path2 = (long)distFrom1[v2] + distFromV2[v1] + distFromV1[N];

		long result = Math.min(path1, path2);

		if (result >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	public static int[] dijkstra(int start) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node currentNode = pq.poll();
			int currentVertex = currentNode.node;
			int currentWeight = currentNode.weight;

			if (dist[currentVertex] < currentWeight) {
				continue;
			}

			for (Node nextNode : graph[currentVertex]) {
				int newDist = dist[currentVertex] + nextNode.weight;
				if (newDist < dist[nextNode.node]) {
					dist[nextNode.node] = newDist;
					pq.add(new Node(nextNode.node, newDist));
				}
			}
		}
		return dist;
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
