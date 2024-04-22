import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, M;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        BinarySearch(1, arr[N - 1]);
        System.out.println(result);
    }

    public static void BinarySearch(int left, int right) {
        int cnt = 0;
        if(left <= right) {
            int mid = (left + right) / 2;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] != 0) {
                    cnt += arr[i] / mid;
                }
                if (cnt >= M) {
                    break;
                }
            }
            if (cnt >= M) {
                result = mid;
                BinarySearch(mid + 1, right);
            }
            if (cnt < M) {
                BinarySearch(left, mid - 1);
            }
        }
    }
}
