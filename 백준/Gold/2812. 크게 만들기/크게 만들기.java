import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split("");
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            while (count < k && !stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
                count++;
            }
            stack.push(arr[i]);
        }
        for (int i = 0; i < n - k; i++) {
            System.out.print(stack.elementAt(i));
        }
    }
}