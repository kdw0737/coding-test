import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        long len = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        long lower = 0;
        long upper = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > upper) {
                upper = arr[i];
            }
        }
        while (lower < upper) {
            long mid = (lower + upper) / 2;
            long sum = 0;
            for (int n : arr) {
                if (n > mid) {
                    sum += (n - mid);
                }
            }
            if (sum < len) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        System.out.println(lower - 1);
    }
}