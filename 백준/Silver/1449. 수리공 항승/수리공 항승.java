import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int tape = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int cnt =0;
        for (int i = 0; i < N;) {
            int tmp = arr[i] + tape - 1;
            int plus = 1;
            while (i+plus <N && arr[i + plus] <= tmp) {
                plus++;
            }
            i+=plus;
            cnt++;
        }
        System.out.println(cnt);
    }
}