import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int tmp = 0;
        for(int i=1; i<N; i++){
            int num = N-i;
            int sum = 0;

            while(num!=0){
                sum+=num%10;
                num/=10;
            }
            if(sum+(N-i)==N){
                tmp=N-i;
            }
        }
        System.out.println(tmp);
    }
}
