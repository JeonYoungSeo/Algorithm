import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-24
 * Description : 백준 11660
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //표 생성
        int[][] chart = new int[N+1][N+1];
        //입력 
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for(int j=1; j<=N; j++) {
        		chart[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        //구간 합 
        int[][] dp = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=N; j++) {
        		dp[i][j] = dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1]+chart[i][j]; 
        	}
        }
        
        //M횟수만큼 값 입/출력
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x1 = Integer.parseInt(st.nextToken()); 
        	int y1 = Integer.parseInt(st.nextToken()); 
        	int x2 = Integer.parseInt(st.nextToken()); 
        	int y2 = Integer.parseInt(st.nextToken()); 
        	
        	int result = dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];
        	
        	
        	bw.write(result+"\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
