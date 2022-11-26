import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int i =0; i<T; i++){
            int N = Integer.parseInt(bf.readLine());
            int[] arr = new int[N];
            for(int j=0; j<N; j++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                arr[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
            }
            int interviewMin = arr[0];
            int count =1;
            for(int j =1; j<arr.length; j++){
                if(arr[j]<interviewMin){
                    interviewMin = arr[j];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}