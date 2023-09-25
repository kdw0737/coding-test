import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        ArrayList<Integer> list = new ArrayList<>(); // 라이언 인형 인덱스 저장
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1) {
                list.add(i);
            }
        }
        if (list.size() < K) {
            System.out.println(-1);
            return;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= list.size() - K + 1; i++) {
            result = Math.min(result, list.get(i + K - 2) - list.get(i - 1) + 1);
        }
        System.out.println(result);
    }
}
