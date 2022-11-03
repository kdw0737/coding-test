import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int count = 0; //결과출력 변수
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
                continue;
            }
                int left = 0;
                int right = arr.length - 1;
                while (left < right) {
                    if(left == i){
                        left++;
                        continue;
                    }
                    if(right == i){
                        right--;
                        continue;
                    }
                    if (arr[left] + arr[right] == arr[i]) {
                        map.put(arr[i], 1);
                        break;
                    }
                    else if (arr[left] + arr[right] > arr[i])
                        right--;
                    else
                        left++;
                }
            }
            for (int key : map.keySet()) {
                count += map.get(key);
            }
            System.out.println(count);
        }
    }