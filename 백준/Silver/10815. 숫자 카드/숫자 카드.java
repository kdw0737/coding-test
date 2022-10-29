import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i =0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int[] check = new int[M];
        for(int i =0; i<M; i++){
            check[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<M; i++){
            sb.append(BinarySearch(arr,check[i])).append(" ");
        }
        System.out.println(sb);
    }
    private static int BinarySearch(int[] arr,int key){
        int left = 0;
        int right = arr.length-1;
        int mid ;

        while(left<=right){
            mid = (left+right)/2;
            if(arr[left] == key || arr[right] == key || key==arr[mid])
                return 1;
            else if(key>arr[mid])
                left = mid+1;
            else
                right = mid-1;
        }
        return 0;
    }
 }