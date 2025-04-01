import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		StringTokenizer st = new StringTokenizer(bf.readLine());
		int dPrice = Integer.parseInt(st.nextToken());
		int tPrice = Integer.parseInt(st.nextToken());
		int dCalories = Integer.parseInt(bf.readLine());
		Integer[] toppings = new Integer[N];

		for (int i = 0; i < N; i++) {
			toppings[i] = Integer.parseInt(bf.readLine());
		}

		// 칼로리 높은 순 정렬
		Arrays.sort(toppings, Collections.reverseOrder());

		int totalPrice = dPrice;
		int totalCalories = dCalories;

		int result = totalCalories / totalPrice;

		for (int i = 0; i < N; i++) {
			totalPrice += tPrice;
			totalCalories += toppings[i];
			int now = totalCalories / totalPrice;
			if (now > result) {
				result = now;
			}
		}

		System.out.println(result);
	}
}
