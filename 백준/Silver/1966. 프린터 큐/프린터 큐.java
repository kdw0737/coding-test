import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int cnt =1;
            int answer =0;
            Integer[] arr = new Integer[N];
            Queue<int[]> que = new LinkedList<>();
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                que.add(new int[]{j, tmp});
                arr[j] = tmp;
            }
            Arrays.sort(arr,Collections.reverseOrder());
            for (int j = 0; j < N; j++) {
                while (true) {
                    if (arr[j] != que.peek()[1]) {
                        que.add(que.poll());
                    } else {
                        if (que.peek()[0] == target) {
                            answer = cnt;
                        }
                        que.poll();
                        cnt++;
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}