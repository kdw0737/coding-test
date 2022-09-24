import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i =1; i<arr.length; i++){
            System.out.println((arr[0]/GCD(arr[0],arr[i]))+"/"+(arr[i]/GCD(arr[0],arr[i])));
        }
    }
    public static int GCD (int A, int B){
        while(B!=0){
            int r = A%B;
            A=B;
            B=r;
        }
        return A;
    }
}