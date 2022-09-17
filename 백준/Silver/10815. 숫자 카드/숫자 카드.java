import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] solution = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solution);
        int M = Integer.parseInt(bf.readLine());
        int[] check = new int[M];
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        for(int i =0; i<M; i++){
            check[i] = Integer.parseInt(st1.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if(BinarySearch(solution,check[i]))
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");
        }
        System.out.println(sb);
    }

    public static boolean BinarySearch(int[] solution, int key) {
        int left = 0;
        int right = solution.length-1;
        int mid;
        while (left<=right) {
            mid = (right + left) / 2;
            if (key == solution[mid] || key ==solution[left] || key == solution[right]) {
                return true;
            }
            else if (key > solution[mid]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
}