import java.util.*;
import java.io.*;

public class Main {
    static int col,row, trash;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int tmp = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        trash = Integer.parseInt(st.nextToken());
        arr = new int[col][row];
        int area = 0;
        for (int i = 0; i < trash; i++) {
            st = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            arr[y][x] = 1;
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (arr[i][j] == 1) {
                    tmp = 0;
                    area = Math.max(area, dfs(i, j));
                }
            }
        }
        System.out.println(area);
    }

    public static int dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < col && nx >= 0 && nx < row) {
                if (arr[ny][nx] == 1) {
                    arr[ny][nx] = 0;
                    dfs(ny, nx);
                    tmp++;
                }
            }
        }
        return tmp;
    }
}
