import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[] arr = new long[101];
        arr[1] = 1 ; arr[2] = 1 ; arr[3] = 1;
        int idx = 4;
        for(int i =0; i<N ;i++){
            int endPoint = Integer.parseInt(bf.readLine());
            while (true) {
                if (arr[endPoint] != 0) {
                    System.out.println(arr[endPoint]);
                    break;
                }
                arr[idx] = arr[idx - 3] + arr[idx - 2];
                if (idx == endPoint) {
                    System.out.println(arr[endPoint]);
                    break;
                }
                idx++;
            }
        }
    }
}