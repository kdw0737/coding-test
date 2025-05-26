import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int result = 0;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// 1초후 : +1, -1   -----  0초후 : *2 로 이동 가능
		// 가장 빨리 만날 수 있는 초 return
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];

		if (n >= k) {
			System.out.println(n - k);
			return;
		}

		bfs(n, k);
		System.out.println(result);
	}

	public static void bfs(int n, int k) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {n, 0});

		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			int pos = cur[0];
			int time = cur[1];

			if (visited[pos]) continue;  
			visited[pos] = true;

			if (pos == k) {
				result = time;
				return;
			}

			if (pos * 2 <= 100000) {
				dq.addFirst(new int[] {pos * 2, time}); 
			}
			if (pos + 1 <= 100000) {
				dq.addLast(new int[] {pos + 1, time + 1});
			}
			if (pos - 1 >= 0) {
				dq.addLast(new int[] {pos - 1, time + 1});
			}
		}
	}
}
