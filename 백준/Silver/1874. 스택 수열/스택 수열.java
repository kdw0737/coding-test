import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (N-- > 0) {
            int num = Integer.parseInt(bf.readLine());
            if (start < num) {
                for (int i = start + 1; i <= num; i++) {
                    stack.push(i);
                    sb.append("+").append('\n');
                }
                start = num;
            } else if (stack.peek() != num) {
                System.out.println("NO");
                System.exit(0);
            }
            stack.pop();
            sb.append("-").append('\n');
        }
        System.out.println(sb);
    }
}