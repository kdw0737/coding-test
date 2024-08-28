import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num,map.getOrDefault(num,0)+1);
		}

		Set<Map.Entry<Integer, Integer>> entry = map.entrySet();
		entry = entry.stream().sorted((o1,o2) -> o2.getValue()-o1.getValue()).collect(Collectors.toCollection(LinkedHashSet::new));
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, Integer> integerIntegerEntry : entry) {
			int key = integerIntegerEntry.getKey();
			for (int i = 0; i < integerIntegerEntry.getValue(); i++) {
				sb.append(key + " ");
			}
		}

		System.out.println(sb);
	}
}
