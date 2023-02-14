import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            Stack<Character> subStack = new Stack<>();
            String str = bf.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '<') {
                    if (!stack.isEmpty()) {
                        subStack.push(stack.pop());
                    }
                } else if (str.charAt(j) == '>') {
                    if (!subStack.isEmpty()) {
                        stack.push(subStack.pop());
                    }
                } else if (str.charAt(j) == '-') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(str.charAt(j));
                }
            }
            while (!stack.isEmpty()) {
                subStack.push(stack.pop());
            }
            while (!subStack.isEmpty()) {
                sb.append(subStack.pop());
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}