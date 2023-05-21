import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;
        int leftNum = Integer.MAX_VALUE;
        int rightNum = Integer.MIN_VALUE;
        int gap = Integer.MAX_VALUE;
        while (left < right) {
            if (Math.abs(arr[left] + arr[right]) < gap) {
                leftNum = arr[left];
                rightNum = arr[right];
                gap = Math.abs(leftNum + rightNum);
                if (arr[left] + arr[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }else if(Math.abs(arr[left] + arr[right]) >= gap){
                if (arr[left] + arr[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }

            if (gap == 0) {
                break;
            }
        }
        System.out.println(leftNum+" "+rightNum);
    }
}
