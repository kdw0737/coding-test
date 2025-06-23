import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] wordMasks;  // 단어마다 필요한 문자 비트마스크
	static boolean[] learned = new boolean[26];
	static int maxCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		wordMasks = new int[N];

		if (K < 5) {
			System.out.println(0);
			return;
		}

		learned[0] = true;
		learned['n' - 'a'] = true;
		learned['t' - 'a'] = true;
		learned['i' - 'a'] = true;
		learned['c' - 'a'] = true;

		int baseMask = 0;
		for (int c : new int[]{'a', 'n', 't', 'i', 'c'}) {
			baseMask |= (1 << (c - 'a'));
		}

		// 단어 입력 및 비트마스크 변환
		for (int i = 0; i < N; i++) {
			String word = bf.readLine();
			String core = word.substring(4, word.length() - 4);

			int mask = 0;
			for (char c : core.toCharArray()) {
				mask |= (1 << (c - 'a'));
			}
			wordMasks[i] = mask;
		}

		dfs(baseMask, 0, 0);

		System.out.println(maxCount);
	}

	static void dfs(int learnedMask, int start, int depth) {
		// 문자를 다 골랐으면 단어 몇 개 읽을 수 있는지 체크
		if (depth == K - 5) {
			int count = 0;
			for (int mask : wordMasks) {
				if ((mask & ~learnedMask) == 0) {
					count++;
				}
			}
			maxCount = Math.max(maxCount, count);
			return;
		}

		for (int i = start; i < 26; i++) {
			if ((learnedMask & (1 << i)) != 0) continue;

			dfs(learnedMask | (1 << i), i + 1, depth + 1);
		}
	}
}