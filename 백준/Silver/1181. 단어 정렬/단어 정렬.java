import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] arr = new String[N];
        for(int i =0; i<N; i++){
            arr[i]=bf.readLine();
        }
        Arrays.sort(arr,(String a, String b)-> a.length()==b.length()? a.compareTo(b) : a.length() - b.length());
        arr = Arrays.stream(arr).distinct().toArray(String[]::new);
        StringBuilder sb = new StringBuilder();
        for(String a : arr)
            sb.append(a).append('\n');
        System.out.println(sb);
    }
}
