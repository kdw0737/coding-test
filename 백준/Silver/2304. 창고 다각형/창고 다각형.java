import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][2]; //[0] -> x좌표 , [1] -> 높이
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < N; i++) {
            if (arr[i][1] > max) {
                max = arr[i][1];
                maxIdx = i;
            }
        }
        int curHeignt = arr[0][1];
        int curIdx = 0;
        int area = 0;
        for (int i = 1; i <= maxIdx; i++) {
            if (curHeignt <= arr[i][1]) {
                area += curHeignt * (arr[i][0] - arr[curIdx][0]);
                curHeignt = arr[i][1];
                curIdx = i;
            }
        }
        curHeignt = arr[N - 1][1];
        curIdx = N - 1;
        for (int i = N - 2; i >= maxIdx; i--) {
            if (curHeignt <= arr[i][1]) {
                area += curHeignt * (arr[curIdx][0] - arr[i][0]);
                curHeignt = arr[i][1];
                curIdx = i;
            }
        }
        System.out.println(area + max);
    }
}