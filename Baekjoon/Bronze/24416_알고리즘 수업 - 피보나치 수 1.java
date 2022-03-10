import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] memo,memo2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N+1];
        memo2 = new int[N+1];
        System.out.println(fib(N)+" "+fibonacci(N));

    }

    private static int fibonacci(int n) {
        if(n==1 || n==2) return 0;
        if(memo2[n]!=0){
            return memo2[n];
        }
        int result = 0;
        for(int i=3; i<=n; i++){
            int t = fibonacci(i - 1) + fibonacci(i - 2);
            result ++;
        }
        memo2[n] = result;
        return result;
    }

    public static int fib(int n){
        if(n==1 || n==2) return 1;
        if(memo[n]!=0){
            return memo[n];
        }
        int result = 0;
        result += (fib(n-1) + fib(n-2));
        memo[n] = result;
        return result;

    }
}
