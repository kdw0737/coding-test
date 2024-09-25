import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][3];
		int[][] maxArr = new int[N][3];
		int[][] minArr = new int[N][3];
		StringTokenizer st;
		for (int i = 0; i <N ; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				minArr[i][j] = Integer.MAX_VALUE;
			}
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			maxArr[0][i] = arr[0][i];
			minArr[0][i] = arr[0][i];
		}
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					maxArr[i + 1][0] = Math.max(maxArr[i][0] + arr[i + 1][0], maxArr[i + 1][0]);
					maxArr[i + 1][1] = Math.max(maxArr[i][0] + arr[i + 1][1], maxArr[i + 1][1]);
					minArr[i + 1][0] = Math.min(minArr[i][0] + arr[i + 1][0], minArr[i + 1][0]);
					minArr[i + 1][1] = Math.min(minArr[i][0] + arr[i + 1][1], minArr[i + 1][1]);
				}else if (j == 1) {
					maxArr[i + 1][0] = Math.max(maxArr[i][1] + arr[i + 1][0], maxArr[i + 1][0]);
					maxArr[i + 1][1] = Math.max(maxArr[i][1] + arr[i + 1][1], maxArr[i + 1][1]);
					maxArr[i + 1][2] = Math.max(maxArr[i][1] + arr[i + 1][2], maxArr[i + 1][2]);
					minArr[i + 1][0] = Math.min(minArr[i][1] + arr[i + 1][0], minArr[i + 1][0]);
					minArr[i + 1][1] = Math.min(minArr[i][1] + arr[i + 1][1], minArr[i + 1][1]);
					minArr[i + 1][2] = Math.min(minArr[i][1] + arr[i + 1][2], minArr[i + 1][2]);
				}else if (j == 2) {
					maxArr[i + 1][1] = Math.max(maxArr[i][2] + arr[i + 1][1], maxArr[i + 1][1]);
					maxArr[i + 1][2] = Math.max(maxArr[i][2] + arr[i + 1][2], maxArr[i + 1][2]);
					minArr[i + 1][1] = Math.min(minArr[i][2] + arr[i + 1][1], minArr[i + 1][1]);
					minArr[i + 1][2] = Math.min(minArr[i][2] + arr[i + 1][2], minArr[i + 1][2]);
				}
			}
		}
		max = Math.max(maxArr[N-1][0], Math.max(maxArr[N-1][1], maxArr[N-1][2]));
		min = Math.min(minArr[N-1][0], Math.min(minArr[N-1][1], minArr[N-1][2]));

		System.out.println(max + " " + min);
	}
}