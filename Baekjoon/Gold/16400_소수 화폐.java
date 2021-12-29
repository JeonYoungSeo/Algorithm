import java.util.*;
import java.io.*;

public class Main {
    static int N, cnt;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        long mod = 123456789;
        boolean[] prime = new boolean[N+1];

        cnt = 0;
        for(int i=2; i<=N; i++){
            boolean first = true;
            for(int j=i; j<=N; j+=i){
                if(prime[j]) continue;
                if(first){
                    first = !first;
                    cnt++;
                    continue;
                }
                prime[j] = true;
            }
        }
        int[] pnum = new int[cnt];
        int num = 0;
        for(int i=2; i<=N; i++){
            if(!prime[i]){
                pnum[num++] = i;
            }
        }

        long[] arr = new long[N+1];
        arr[0] = 1;
        for(int i=0; i<cnt; i++){
            
            for(int j=pnum[i]; j<=N; j++){
                arr[j] = (arr[j] + arr[j-pnum[i]])%mod;
            }
        }
        if(N<=3){
            System.out.println(1);
            return;
        }
        System.out.println(arr[N]);



    }

}
