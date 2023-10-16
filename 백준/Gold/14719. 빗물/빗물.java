import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int leftMax = 0;
    static int rightMax = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        arr = new int[width];
        for (int i = 0; i < width; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 1;
        while (true) {
            if (idx == width) {
                System.out.println(result);
                break;
            }
            checkMax(idx);
            if (arr[idx] < rightMax && arr[idx] < leftMax) {
                result += Math.min(leftMax, rightMax) - arr[idx];
            }
            leftMax = 0;
            rightMax = 0;
            idx++;
        }
    }

    static public void checkMax(int idx) {
        for (int i = 0; i < idx; i++) {
            leftMax = Math.max(arr[i], leftMax);
        }
        for (int i = idx + 1; i < arr.length; i++) {
            rightMax = Math.max(arr[i], rightMax);
        }
    }
}
