import java.io.*;
import java.util.*;
//value 에 맞는 key값을 뽑아내는것도 가능하지만 케이스 경우가 많을시 시간초과가 발생하기 때문에 두개의 HashMap 을 생성한다.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> book1 = new HashMap<>();
        HashMap<Integer,String> book2 = new HashMap<>();
        char tmp;
        String tmp2;
        StringBuilder sb = new StringBuilder();
        for(int i =1; i<=N; i++){
            tmp2 = bf.readLine();
            book1.put(tmp2,i);
            book2.put(i,tmp2);
        }
        for(int i =0; i<M; i++){
            String input = bf.readLine();
            tmp = input.charAt(0);
            if(Character.isDigit(tmp)){
                sb.append(book2.get(Integer.parseInt(input))).append("\n");
            }
            else{
                sb.append(book1.get(input)).append("\n");
            }
        }
        System.out.println(sb);
    }
}