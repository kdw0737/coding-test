import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int count =0;
        int[] arr = new int[5];

        while (true) {
            if(count==N)
                break;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < 5; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            if (arr[3] - arr[1] > 3)
                System.out.println("KIN");
            else
                System.out.println(arr[1]+arr[2]+arr[3]);
            count++;
        }
    }
}