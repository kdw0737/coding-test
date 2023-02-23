import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static int[][] map;
    static int[][] dp;
    static int height;
    static int width;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new int[height][width];
        dp = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = map[0][0];
        dfs();
        System.out.println(dp[height-1][width-1]);
    }

    private static void dfs() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < 3; k++) {
                    if(i+dy[k]>=0 && i+dy[k]<height && j+dx[k]>=0 && j+dx[k]<width) {
                        dp[i + dy[k]][j + dx[k]] = Math.max(map[i + dy[k]][j + dx[k]] + dp[i][j], dp[i + dy[k]][j + dx[k]]);
                    }
                }
            }
        }
    }
}
