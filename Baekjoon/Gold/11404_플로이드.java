import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-17
 * Description : 백준 11404 플로이드 와샬 적용
 */


public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(cost[i][j] == 0) {
					cost[i][j] = 10000001;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			cost[a-1][b-1] = (cost[a-1][b-1]<c)?cost[a-1][b-1]:c;
		}
		
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				if(k==i) continue;
				for(int j=0; j<n; j++) {
					if(j==k || j==i) continue;
					
					cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
				}
			}
		}
		
		for(int[] line : cost) {
			for(int num : line) {
				if(num== 10000001) {
					bw.write("0 ");
					continue;
				}
				bw.write(num+" ");
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
