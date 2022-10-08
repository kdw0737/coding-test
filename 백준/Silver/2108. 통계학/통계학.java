import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        System.out.println(avg(arr));
        System.out.println(cenValue(arr));
        System.out.println(most(arr));
        System.out.println(range(arr));
    }

    private static int avg(int[] arr) {
        double sum = 0;
        for (int a : arr) {
            sum += a;
        }
        return (int) Math.round(sum / arr.length);
    }

    private static int cenValue(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }

    private static int most(int[] arr) {
        int[] tmp = new int[8001];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            tmp[arr[i] + 4000]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<tmp.length; i++){
            max=Math.max(max,tmp[i]);
        }
        for(int i = 0; i<tmp.length; i++){
            if(tmp[i]==max && !(list.contains(i))){
                list.add(i);
            }
        }
        if(list.size()>=2)
            return list.get(1)-4000;
        else
            return list.get(0)-4000;
    }

    private static int range(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1]-arr[0];
    }
}