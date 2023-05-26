import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == weight) {
                System.out.println(1);
                return;
            }
            list.add(num);
        }
        Collections.sort(list);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) + list.get(right) < weight) {
                int tmp = weight - (list.get(left) + list.get(right));
                if (list.get(left) != tmp && list.get(right) != tmp && list.contains(tmp)) {
                    System.out.println(1);
                    return;
                }
                left++;
            } else if (list.get(left) + list.get(right) == weight) {
                System.out.println(1);
                return;
            } else {
                right--;
            }
        }
        System.out.println(0);
    }
}