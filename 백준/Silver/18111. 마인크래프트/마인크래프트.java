import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int block = Integer.parseInt(st.nextToken());
        int[][] arr = new int[row][col];
        int max = 0;
        int min = 257;

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        int minHeight = 0; // 최소 높이를 0으로 초기화
        int minTime = Integer.MAX_VALUE; // 최소 시간을 최대값으로 초기화

        for (int height = min; height <= max; height++) {
            int time = 0;
            int remain = block;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int diff = arr[i][j] - height;
                    time += (diff > 0) ? 2 * diff : -diff;
                    remain += diff;
                }
            }

            if (remain >= 0 && time <= minTime) {
                minTime = time;
                minHeight = height;
            }
        }

        System.out.println(minTime + " " + minHeight);
    }
}
