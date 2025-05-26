import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Deque<int[]> dq = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < N; i++) {
			dq.addLast(new int[]{Integer.parseInt(st.nextToken()), i + 1});
		}

		StringBuilder sb = new StringBuilder();

		int[] current = dq.pollFirst(); // 첫 풍선
		sb.append(current[1]).append(" "); // 풍선 번호 출력
		int move = current[0]; // 이동할 칸 수

		while (!dq.isEmpty()) {
			// 양수면 move - 1만큼 오른쪽으로
			if (move > 0) {
				for (int i = 0; i < move - 1; i++) {
					dq.addLast(dq.pollFirst());
				}
				current = dq.pollFirst();
			}
			// 음수면 |move| 만큼 왼쪽으로
			else {
				for (int i = 0; i < Math.abs(move); i++) {
					dq.addFirst(dq.pollLast());
				}
				current = dq.pollFirst();
			}

			sb.append(current[1]).append(" ");
			move = current[0];
		}

		System.out.println(sb);
	}
}
