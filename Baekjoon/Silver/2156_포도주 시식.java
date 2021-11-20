import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int[] gr = new int[N+1];

        for(int i=1; i<=N; i++){
            gr[i] = Integer.parseInt(br.readLine());
        }

        memo = new int[N+1];
        Arrays.fill(memo, -1);
        cnt(N,gr);
        System.out.println(Math.max(memo[N-1], memo[N]));
    }

    private static int cnt(int n, int[] gr) {
        if(memo[n]!=-1)
            return memo[n];

        if(n>=3){
            memo[n] = Math.max(cnt(n-2,gr)+gr[n], Math.max(cnt(n-3,gr)+gr[n-1]+gr[n],cnt(n-1,gr)));
        }else{
            int result = 0;
            for(int i=1; i<=n; i++){
                result += gr[i];
            }
            memo[n] = result;
            return memo[n];
        }

        return memo[n];
    }
}
