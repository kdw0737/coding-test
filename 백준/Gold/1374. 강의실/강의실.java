import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 강의 번호
			arr[i][1] = Integer.parseInt(st.nextToken()); // 시작 시간
			arr[i][2] = Integer.parseInt(st.nextToken()); // 종료 시간
		}

		Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int start = arr[i][1];
			int end = arr[i][2];

			if (!pq.isEmpty() && pq.peek() <= start) {
				pq.poll();
			}

			pq.add(end); // 새 강의실 배정 or 재사용된 강의실에 새 종료시간 입력
		}

		System.out.println(pq.size()); 
	}
}
