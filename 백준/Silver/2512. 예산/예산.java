import java.io.*;
import java.util.*;

public class Main {
    static int sum =0;
    static int M ;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum+=arr[i];
        }
        M = Integer.parseInt(bf.readLine());
        Arrays.sort(arr);
        System.out.println(BinarySearch(arr));
        }

    public static long BinarySearch(int[] arr) {
        long left =0;
        long right =M;
        long mid;
        long max =0;
        if(sum<=M)
            return arr[arr.length-1];
        else {
            while (left <= right) {
                int current = 0;
                mid = (left + right) / 2;
                for (int money : arr) {
                    if (money > mid)
                        current += mid;
                    else
                        current += money;
                }
                if (current > M)
                    right = mid - 1;
                else {
                    left = mid + 1;
                    max = Math.max(max, mid);
                }
            }
            return max;
        }
    }
}