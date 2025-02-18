import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		// 0 : day , 1 : point
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));
		int maxDay = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int[] arr = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			pq.add(arr);
			maxDay = Math.max(maxDay, arr[0]);
		}

		int result = 0;
		boolean[] visited = new boolean[maxDay + 1];

		while(!pq.isEmpty()) {
			int[] arr = pq.poll();
			if (!visited[arr[0]]) {
				result += arr[1];
				visited[arr[0]] = true;
			} else {
				for (int i = arr[0] - 1; i >= 1; i--) {
					if (!visited[i]) {
						visited[i] = true;
						result += arr[1];
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
}
