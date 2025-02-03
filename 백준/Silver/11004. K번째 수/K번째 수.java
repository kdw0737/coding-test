import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		System.out.println(list.get(k - 1));
	}
}
