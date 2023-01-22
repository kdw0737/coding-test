import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            Arrays.sort(arr);
            long tmp = arr[0] + arr[1];
            arr[0] = tmp;
            arr[1] = tmp;
        }
        long sum = 0;
        for (long n : arr) {
            sum+=n;
        }
        System.out.println(sum);
    }
}