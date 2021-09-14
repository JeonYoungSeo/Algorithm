import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-14
 * Description : 백준 1149
 */


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
	////위에서부터 최솟값이 되게 가능한 작은수를 더해준다.
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) {
				cost[i][j] += Math.min(cost[i-1][(j+1)%3],cost[i-1][(j+2)%3]);
			}
		}
		
		int result = 987654321;
		
		for(int i=0; i<3; i++) {
			result = Math.min(result, cost[N-1][i]);
		}
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
