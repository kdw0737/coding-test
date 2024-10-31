import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] arr = new int[n];
		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				result[stack.pop()] = arr[i];
			}
			stack.push(i);
		}

		while(!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i : result) {
			sb.append(i).append(" ");
		}

		System.out.println(sb);
	}
}