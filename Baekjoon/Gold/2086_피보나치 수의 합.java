import java.util.*;
import java.io.*;


public class Main {
    static long mod = 1_000_000_000L;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long result = 0L;

        long ra[][];
        long rb[][];
        long result_a = 0;
        long result_b = 0;


        if(a>3) {
             ra = pow(a - 2);
             for(int i=0; i<4; i++){
                 result_a = (result_a+ra[i/2][i%2])%mod;
             }
             result_a--;
        }else{
            if(a<=1){
                result_a = 0;
            }else if(a==2){
                result_a = 1;
            }else if(a==3){
                result_a = 2;
            }
        }
        if(b>2) {
            rb = pow(b - 1);
            for(int i=0; i<4; i++){
                result_b = (result_b+rb[i/2][i%2])%mod;
            }
            result_b--;
        }else{
            if(b<=0){
                result_b = 0;
            }else if(b==1){
                result_b = 1;
            }else if(b==2){
                result_b = 2;
            }
        }

        System.out.println((result_b+mod-result_a)%mod);

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
