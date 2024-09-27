import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		System.out.println(list.size());
		Collections.sort(list);
		for (Integer i : list) {
			System.out.println(i);
		}
	}

	static void dfs(int idx, int target) {
		if (arr[idx] == target) {
			list.add(target);
		}
		if (!visited[arr[idx]]) {
			visited[arr[idx]] = true;
			dfs(arr[idx], target);
			visited[arr[idx]] = false;
		}
	}
}