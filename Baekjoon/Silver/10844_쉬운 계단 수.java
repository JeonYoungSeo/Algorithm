import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] memo;
    static int N ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        memo = new int[N+1][10];
        System.out.println(stair(0,0));
    }

    private static int stair(int before, int n) {
        if(n==N){
            return 1;
        }
        if(memo[n][before]!=0){
            return memo[n][before];
        }
        int result = 0;

        if(n==0){
            for(int i=1; i<10; i++){
                result += stair(i,n+1);
                result %= 1_000_000_000;
            }
        }else{
            int num = before+1;
            int num2= before-1;
            if(num<10){
                result += stair(num, n+1);
                result %= 1_000_000_000;
            }
            if(num2>=0){
                result += stair(num2, n+1);
                result %= 1_000_000_000;
            }
        }
        memo[n][before] = result;
        return memo[n][before];
    }
}
