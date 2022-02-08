import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N+1][3];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N+1][3];
        int result = 987654321;

        //1. 1번에서 출발할때
        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = cost[i][j];
            }
        }
        dp[1][0] = Integer.MAX_VALUE;
        dp[1][1] = dp[0][0]+dp[1][1];
        dp[1][2] = dp[0][0]+dp[1][2];

        for(int i=2; i<=N; i++) {
            for(int j=0; j<3; j++) {
                dp[i][j] += Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]);
            }
        }
        for(int i=1; i<3; i++) {
            result = Math.min(result, dp[N-1][i]);
        }
        //2번에서 시작할때
        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = cost[i][j];
            }
        }
        dp[1][1] = Integer.MAX_VALUE;
        dp[1][0] = dp[0][1]+dp[1][0];
        dp[1][2] = dp[0][1]+dp[1][2];

        for(int i=2; i<=N; i++) {
            for(int j=0; j<3; j++) {
                dp[i][j] += Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]);
            }
        }
        result = Math.min(result, dp[N-1][0]);
        result = Math.min(result, dp[N-1][2]);

        //3번에서 시작했을때
        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = cost[i][j];
            }
        }
        dp[1][2] = Integer.MAX_VALUE;
        dp[1][0] = dp[0][2]+dp[1][0];
        dp[1][1] = dp[0][2]+dp[1][1];

        for(int i=2; i<=N; i++) {
            for(int j=0; j<3; j++) {
                dp[i][j] += Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]);
            }
        }
        result = Math.min(result, dp[N-1][0]);
        result = Math.min(result, dp[N-1][1]);


        bw.write(result+"\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
