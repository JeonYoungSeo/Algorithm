import java.util.*;
import java.io.*;


public class Main {

    static long[][] dp;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = -1;

        dp = new long[31][31];

        while(true){
            long result = 0;

            N = Integer.parseInt(br.readLine());

            if(N==0){
                return;
            }
            System.out.println(drug(N, 0));

        }
    }

    private static long drug(int W, int H) {
        if(dp[W][H] != 0){
            return dp[W][H];
        }

        if(W == 0){
            return 1;
        }

        long result = 0;

        result += drug(W-1,H+1);
        if(H>=1)
            result += drug(W, H-1);

        dp[W][H] = result;
        return result;

    }
}
