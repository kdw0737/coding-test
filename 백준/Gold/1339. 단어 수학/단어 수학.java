import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> map = new HashMap<>();
		int N = Integer.parseInt(bf.readLine());
		int result = 0;
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			int idx = 0;
			for (int j = str.length() - 1; j >= 0; j--) {
				map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + (int)Math.pow(10, idx));
				idx++;
			}
		}
		List<Integer> list = new ArrayList<>();
		for (Character c : map.keySet()) {
			list.add(map.get(c));
		}
		Collections.sort(list, Collections.reverseOrder());

		int num = 9;
		for (int i = 0; i < list.size(); i++) {
			result += num * list.get(i);
			num--;
		}

		System.out.println(result);
	}
}
