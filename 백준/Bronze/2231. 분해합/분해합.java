import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        boolean check = false;
        for(int i =1; i<N ; i++){
            int sum = i;
            int tmp =i;
            while(tmp>0){
                sum+=tmp%10;
                tmp/=10;
            }
            if(sum==N) {
                check = true;
                System.out.println(i);
                break;
            }
        }
        if(!check)
            System.out.println(0);
    }
}