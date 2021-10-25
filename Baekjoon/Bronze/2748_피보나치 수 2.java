import java.io.*;



/*
  간단한 피보나치 함수 문제이다.
*/

public class Main{

    static long[] memo;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        memo = new long[n+1];

        System.out.println(fibo(n));

    }

    public static long fibo(int n){
        if(n==1){
            return 1;
        }else if (n==0){
            return 0;
        }

        if(memo[n]!=0){
            return memo[n];
        }

        memo[n] =  fibo(n-1)+ fibo(n-2);

        return memo[n];
    }
}
