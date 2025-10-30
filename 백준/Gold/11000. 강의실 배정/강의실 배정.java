import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 최소 강의실 개수 return
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[i][0] = start;
			arr[i][1] = end;
		}

		Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // { 시작, 끝 }

		for (int i = 0; i < N; i++) {
			int start = arr[i][0];
			int end = arr[i][1];

			if (!pq.isEmpty() && pq.peek() <= start) {
				pq.poll();
			}

			pq.add(end);
		}

		System.out.println(pq.size());
	}
}
