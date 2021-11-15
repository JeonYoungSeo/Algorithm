import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[10001];
        prime[1] = true;
        for(int i=2; i<=100; i++){

            if(prime[i]) continue;

            int num = i*2;

            while(num<10001){
                prime[num] = true;
                num+=i;
            }
        }

        int min = 0;
        int sum = 0;

        for(int i=M; i<=N; i++){
            if(!prime[i]){
                sum += i;
                if(min == 0){
                    min = i;
                }
            }
        }

        if(sum==0){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(min);
        }

    }
}
