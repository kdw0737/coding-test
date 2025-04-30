import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] curFood;
	static int[][] addFood;
	static Deque<Integer>[][] trees;
	static int[][] delta = {
		{-1, -1}, {-1, 0}, {-1, 1},
		{0, -1},          {0, 1},
		{1, -1},  {1, 0}, {1, 1}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		curFood = new int[N][N];
		addFood = new int[N][N];
		trees = new ArrayDeque[N][N];

		// 양분 초기화 및 나무 구조 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				curFood[i][j] = 5; // 초기 양분
				addFood[i][j] = Integer.parseInt(st.nextToken());
				trees[i][j] = new ArrayDeque<>();
			}
		}

		// 나무 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			trees[y][x].add(age);
		}

		// K년 반복
		for (int year = 0; year < K; year++) {
			// 1. 봄 + 여름
			int[][] deadFood = new int[N][N]; // 죽은 나무들이 남긴 양분

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (trees[i][j].isEmpty()) continue;

					Deque<Integer> alive = new ArrayDeque<>();
					int size = trees[i][j].size();

					for (int k = 0; k < size; k++) {
						int age = trees[i][j].pollFirst();
						if (curFood[i][j] >= age) {
							curFood[i][j] -= age;
							alive.addLast(age + 1);
						} else {
							deadFood[i][j] += age / 2;
						}
					}
					trees[i][j] = alive;
				}
			}

			// 여름 - 죽은 나무 양분으로 변환
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					curFood[i][j] += deadFood[i][j];
				}
			}

			// 2. 가을 - 번식
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int age : trees[i][j]) {
						if (age % 5 == 0) {
							for (int[] d : delta) {
								int ny = i + d[0];
								int nx = j + d[1];
								if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
									trees[ny][nx].addFirst(1); // 나이가 1인 나무 앞에 추가
								}
							}
						}
					}
				}
			}

			// 3. 겨울 - 양분 추가
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					curFood[i][j] += addFood[i][j];
				}
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result += trees[i][j].size();
			}
		}

		System.out.println(result);
	}
}