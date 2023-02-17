import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < T; k++) {
            int N = Integer.parseInt(bf.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int M = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < M; i++) {
                if (Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}