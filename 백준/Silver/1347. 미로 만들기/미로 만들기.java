import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] arr = new int[100][100];
		String[] dir = bf.readLine().split("");
		int x = 50, y = 50;
		int minx = 50, miny = 50;
		int maxx = 50, maxy = 50;
		arr[y][x] = 1;
		String[] curDir = {"S", "E", "N", "W"};
		int curDirIdx = 0;

		for (int i = 0; i < dir.length; i++) {
			if(dir[i].equals("R")) {
				if (curDirIdx == 0) {
					curDirIdx = 3;
				} else {
					curDirIdx--;
				}
			} else if (dir[i].equals("L")) {
				if (curDirIdx == 3) {
					curDirIdx = 0;
				} else {
					curDirIdx++;
				}
			} else {
				if(curDirIdx == 0) {
					y++;
				}else if(curDirIdx == 1) {
					x++;
				} else if (curDirIdx == 2) {
					y--;
				} else {
					x--;
				}
				arr[y][x] = 1;
			}
			minx = Math.min(minx, x);
			miny = Math.min(miny, y);
			maxx = Math.max(maxx, x);
			maxy = Math.max(maxy, y);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = miny; i <= maxy; i++) {
			for (int j = minx; j <= maxx; j++) {
				if (arr[i][j] == 1) {
					sb.append(".");
				} else {
					sb.append("#");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
