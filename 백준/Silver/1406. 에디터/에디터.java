import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int N = Integer.parseInt(bf.readLine());
        Stack<String> origin = new Stack<>();
        Stack<String> sub = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            origin.push(String.valueOf(str.charAt(i)));
        }
        for (int i = 0; i < N; i++) {
            String[] arr = bf.readLine().split(" ");
            if (arr[0].equals("P")) {
                origin.push(arr[1]);
            } else if (!origin.isEmpty() && arr[0].equals("L")) {
                sub.push(origin.pop());
            } else if (!sub.isEmpty() && arr[0].equals("D")) {
                origin.push(sub.pop());
            } else if (!origin.isEmpty() && arr[0].equals("B")) {
                origin.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (!origin.isEmpty()) {
            sb.append(origin.pop());
        }
        sb.reverse();
        while (!sub.isEmpty()) {
            sb2.append(sub.pop());
        }
        sb.append(sb2);
        System.out.println(sb);
    }
}