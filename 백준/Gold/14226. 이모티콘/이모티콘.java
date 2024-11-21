import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		bfs(N);
	}

	public static void bfs(int target) {
		Queue<Node> q = new LinkedList<>();
		// 방문 상태 체크를 위한 맵 (각 cnt에 대해 board 상태를 체크)
		Map<Integer, Map<Integer, Boolean>> visited = new HashMap<>();

		// 초기 상태: 1개 이모티콘, 시간 0, 클립보드에는 0
		q.add(new Node(1, 0, 0));
		visited.put(1, new HashMap<>());
		visited.get(1).put(0, true);

		while (!q.isEmpty()) {
			Node node = q.poll();

			// 목표 값에 도달하면 종료
			if (node.cnt == target) {
				System.out.println(node.time);
				return;
			}

			// 1. 전체 복사
			if (!visited.containsKey(node.cnt) || !visited.get(node.cnt).containsKey(node.cnt)) {
				visited.computeIfAbsent(node.cnt, k -> new HashMap<>()).put(node.cnt, true);
				q.add(new Node(node.cnt, node.time + 1, node.cnt));
			}

			// 2. 붙여넣기
			if (node.cnt + node.board <= target &&
				(!visited.containsKey(node.cnt + node.board) || !visited.get(node.cnt + node.board).containsKey(node.board))) {
				visited.computeIfAbsent(node.cnt + node.board, k -> new HashMap<>()).put(node.board, true);
				q.add(new Node(node.cnt + node.board, node.time + 1, node.board));
			}

			// 3. 한개 삭제
			if (node.cnt > 1 && (!visited.containsKey(node.cnt - 1) || !visited.get(node.cnt - 1).containsKey(node.board))) {
				visited.computeIfAbsent(node.cnt - 1, k -> new HashMap<>()).put(node.board, true);
				q.add(new Node(node.cnt - 1, node.time + 1, node.board));
			}
		}
	}

	static class Node {
		int cnt;  // 현재 이모티콘 개수
		int time; // 경과 시간
		int board; // 클립보드에 복사된 이모티콘 개수

		public Node(int cnt, int time, int board) {
			this.cnt = cnt;
			this.time = time;
			this.board = board;
		}
	}
}