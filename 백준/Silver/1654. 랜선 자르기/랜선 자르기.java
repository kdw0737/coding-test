import java.io.*;
import java.util.*;

public class Main {
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i =0; i<N; i++){
            arr[i]=Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        System.out.println(BinarySearch(arr));
    }
    public static long BinarySearch(int[] arr){
        long left = 1;
        long right = arr[arr.length-1];
        long mid;
        long max =0;
        while(left<=right){
            int count =0;
            mid = (left+right)/2;
            for(int length : arr){
                count+=length/mid;
            }
            if(count<M)
                right = mid-1;
            else{
                left = mid +1;
                max = Math.max(max,mid);
            }
        }
        return max;
    }
}