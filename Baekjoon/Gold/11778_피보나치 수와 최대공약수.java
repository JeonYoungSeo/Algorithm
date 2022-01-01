import java.util.*;
import java.io.*;


public class Main {
    static long mod = 1_000_000_007L;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long n = gcd(a,b);


        if(n==0){
            System.out.println(0);
            return;
        }else if(n<=1){
            System.out.println(1);
            return;
        }
        long[][] result = pow(n-1);

        System.out.println(result[0][0]);
    }

    private static long gcd(long a, long b) {
        if(b==0){
            return a;
        }
        else
        {
            return gcd(b, a%b);
        }

    }


    private static long[][] pow(long n) {

        if(n==1){
            long[][] result = new long[2][2];
            result[0][0] = 1;
            result[0][1] = 1;
            result[1][0] = 1;
            result[1][1] = 0;

            return result;
        }

        long[][] result = new long[2][2];

        long[][] temp = pow(n/2);


        result[0][0] = ((temp[0][0]*temp[0][0])%mod+(temp[0][1]*temp[1][0])%mod)%mod;
        result[0][1] = ((temp[0][0]*temp[0][1])%mod+(temp[0][1]*temp[1][1])%mod)%mod;
        result[1][0] = ((temp[1][0]*temp[0][0])%mod+(temp[1][1]*temp[1][0])%mod)%mod;
        result[1][1] = ((temp[1][0]*temp[0][1])%mod+(temp[1][1]*temp[1][1])%mod)%mod;

        if(n%2!=0){
            long[][] temp2 = {{1,1},{1,0}};
            for(int i=0; i<4; i++) temp[i/2][i%2] = result[i/2][i%2]%mod;
            result[0][0] = ((temp[0][0]*temp2[0][0])%mod+(temp[0][1]*temp2[1][0])%mod)%mod;
            result[0][1] = ((temp[0][0]*temp2[0][1])%mod+(temp[0][1]*temp2[1][1])%mod)%mod;
            result[1][0] = ((temp[1][0]*temp2[0][0])%mod+(temp[1][1]*temp2[1][0])%mod)%mod;
            result[1][1] = ((temp[1][0]*temp2[0][1])%mod+(temp[1][1]*temp2[1][1])%mod)%mod;
        }

        return result;

    }
}
