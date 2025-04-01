import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 같은 종류 토핑 2개 이상 x
		// 토핑을 선택 안해도됨
		// 가격 : 도우 + 토핑 * 종류 수
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

		Arrays.sort(toppings, Collections.reverseOrder());

		int weight = dCalories;
		int price = dPrice;
		int result = weight / price;

		for (Integer topping : toppings) {
			price += tPrice;
			weight += topping;
			result = Math.max(result, weight / price);
		}

		System.out.println(result);
	}
}