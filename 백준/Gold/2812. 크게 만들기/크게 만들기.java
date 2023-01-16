import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answerSize = N-K;
        String[] str = bf.readLine().split("");
        Deque<Integer> deque = new ArrayDeque<>();
        int deleteCount = 0;
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            while ( K > 0 && !deque.isEmpty() && deque.peekLast() < arr[i]) {
                deque.pollLast();
                K--;
            }
            deque.addLast(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answerSize; i++) {
            sb.append(deque.pollFirst());
        }
        System.out.println(sb);
    }
}