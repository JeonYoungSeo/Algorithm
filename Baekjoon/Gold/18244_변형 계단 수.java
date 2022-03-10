import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][][][] memo;
    static int N ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        memo = new int[3][3][N+1][10];
        System.out.println(stair(0,0,0,0));
    }

    private static int stair(int up, int down, int before, int n) {
        if(n==N){
            return 1;
        }
        if(memo[up][down][n][before]!=0){
            return memo[up][down][n][before];
        }
        int result = 0;

        if(n==0){
            for(int i=0; i<10; i++){
                result += stair(0,0,i,n+1);
                result %= 1_000_000_007;
            }
        }else{
            int num = before+1;
            int num2= before-1;
            if(num<10 && up <=1){
                result += stair(up+1,0,num, n+1);
                result %= 1_000_000_007;
            }
            if(num2>=0 && down<=1){
                result += stair(0,down+1,num2, n+1);
                result %= 1_000_000_007;
            }
        }
        memo[up][down][n][before] = result;
        return memo[up][down][n][before];
    }
}
