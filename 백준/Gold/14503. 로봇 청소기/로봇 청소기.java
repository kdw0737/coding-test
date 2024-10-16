import java.io.*;
import java.util.*;

public class Main {
	static int[][] dirArr = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[][] arr;
	static int dir,y, x;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());
		int sy = Integer.parseInt(st.nextToken()); // 시작점 y
		int sx = Integer.parseInt(st.nextToken()); //시작점 x
		dir = Integer.parseInt(st.nextToken()); // 0: 북 , 1: 동 , 2 : 남 , 3 : 서
		arr = new int[y][x];

		for (int i = 0; i < y; i++) { // 0 : 청소되지 않은 지역 , 1 : 벽
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < x; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;

		while (true) {
			if (arr[sy][sx] == 0) { // 청소되지 않은 지역이면 청소
				arr[sy][sx] = 2;
				cnt++;
			}

			if (isAroundClean(sy, sx)) { // 주변에 청소되지 않은 칸이 없다면
				if (arr[sy + dirArr[dir][0] * -1][sx + dirArr[dir][1] * -1] == 1) { // 뒤가 벽이면 정지
					break;
				} else { // 뒤가 벽이 아닌 경우 후진
					sy += dirArr[dir][0] * -1;
					sx += dirArr[dir][1] * -1;
				}
			} else { // 주변에 청소되지 않은 칸이 있다면
				sy += dirArr[dir][0];
				sx += dirArr[dir][1];
			}
		}
		System.out.println(cnt);
	}

	public static boolean isAroundClean(int y, int x) {
		for (int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4;
			int ny = y + dirArr[dir][0]; // 반시계 방향
			int nx = x + dirArr[dir][1];
			if (arr[ny][nx] == 0) {
				return false; // 청소하지 않은 칸이 있는경우
			}
		}
		return true;
	}
}