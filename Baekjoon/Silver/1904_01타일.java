import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        memo = new int[N+1];

        System.out.println(cnt(N));
    }

    static int[] memo;
    public static int cnt(int N){
        if(N==0){
            return 1;
        }else if(N<0){
            return 0;
        }

        if(memo[N]!=0){
            return memo[N];
        }

        int result = 0;

        result += cnt(N-1);
        result += cnt(N-2);

        memo[N] = result%15746;

        return memo[N];
    }
}
