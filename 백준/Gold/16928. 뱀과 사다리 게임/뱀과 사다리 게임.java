import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 100번 칸에 도착하기 위해서 최소 몇번을 굴려야 하는지 ?
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사다리 수
		int M = Integer.parseInt(st.nextToken()); // 뱀의 수

		int[] ladders = new int[101];
		int[] snakes = new int[101];
		boolean[] visited = new boolean[101];

		for (int i = 0; i < N; i++) {
			String[] arr = bf.readLine().split(" ");
			ladders[Integer.parseInt(arr[0])] = Integer.parseInt(arr[1]);
		}

		for (int i = 0; i < M; i++) {
			String[] arr = bf.readLine().split(" ");
			snakes[Integer.parseInt(arr[0])] = Integer.parseInt(arr[1]);
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1, 0}); // [ 현재 위치, 주사위 횟수 ]
		visited[1] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[0] == 100) {
				System.out.println(cur[1]);
				break;
			}

			for (int i = 1; i <= 6; i++) {
				int next = cur[0] + i;

				if (isIn(next) && !visited[next]) {
					visited[next] = true;
					if (ladders[next] != 0) {
						q.add(new int[] {(ladders[next]), cur[1] + 1});
					} else if (snakes[next] != 0) {
						q.add(new int[] {(snakes[next]), cur[1] + 1});
					} else {
						q.add(new int[] {next, cur[1] + 1});
					}
				}
			}
		}
	}

	public static boolean isIn(int idx) {
		return 0 <= idx && idx < 101;
	}
}