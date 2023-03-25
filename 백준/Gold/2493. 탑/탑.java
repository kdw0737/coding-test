import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek()[0] > num) {
                    sb.append(stack.peek()[1] + " ");
                    break;
                }else{
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                sb.append(0 + " ");
            }
            stack.push(new int[]{num, i + 1});
        }
        System.out.println(sb);
    }
}