import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();

		// 입력받으며 길이 M 이상인 단어만 저장
		for (int i = 0; i < N; i++) {
			String word = bf.readLine();
			if (word.length() >= M) {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}

		List<String> words = new ArrayList<>(map.keySet());

		// 정렬 기준:
		// 1. 빈도 수 내림차순
		// 2. 길이 내림차순
		// 3. 알파벳 오름차순
		Collections.sort(words, (o1, o2) -> {
			int freq1 = map.get(o1);
			int freq2 = map.get(o2);

			if (freq1 != freq2) {
				return freq2 - freq1;
			} else if (o1.length() != o2.length()) {
				return o2.length() - o1.length();
			} else {
				return o1.compareTo(o2);
			}
		});

		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			sb.append(word).append("\n");
		}
		System.out.print(sb);
	}
}