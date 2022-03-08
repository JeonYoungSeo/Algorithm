import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[N+1];
        int[] primes = new int[N+1];
        int pos = 0;
        for(int i=2; i<=N/2; i++){
            for(int j=i*2; j<=N; j+=i){
                prime[j] = true;
            }
        }
        for(int i=2; i<=N; i++){
            if(!prime[i]){
                primes[pos++] = i;
            }
        }
        int result = 0;
        for(int i=0; i<N; i++){
            if(primes[i]>N) break;
            int num = 0;
            for(int j=i; j<N; j++){
                num+= primes[j];
                if(primes[j]==0) break;
                if(num==N){
                    result++;
                    break;
                }else if(num>N){
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
