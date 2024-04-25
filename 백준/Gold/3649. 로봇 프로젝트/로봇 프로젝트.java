import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = bf.readLine()) != null) {
            int width = Integer.parseInt(str) * 10000000;
            int N = Integer.parseInt(bf.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(bf.readLine());
            }
            Arrays.sort(arr);
            int left = 0;
            int right = N - 1;
            boolean check = false;
            while (left < right) {
                if (arr[left] + arr[right] < width) {
                    left++;
                } else if (arr[left] + arr[right] > width) {
                    right--;
                } else {
                    System.out.println("yes" + " " + arr[left] + " " + arr[right]);
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("danger");
            }
        }
    }
}