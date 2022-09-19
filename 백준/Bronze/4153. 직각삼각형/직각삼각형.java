import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(bf.readLine());
            int[] arr = new int[3];
            arr[0]=Integer.parseInt(st.nextToken());
            arr[1]=Integer.parseInt(st.nextToken());
            arr[2]=Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            if(arr[0]==0 && arr[1]==0 && arr[2]==0)
                break;
            if(Math.pow(arr[0],2)+Math.pow(arr[1],2)==Math.pow(arr[2],2))
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}