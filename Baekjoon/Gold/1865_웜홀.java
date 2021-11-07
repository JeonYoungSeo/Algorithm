import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
	out : while(tc-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int[][] time = new int[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				Arrays.fill(time[i], 987_654_321);
			}
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				time[S][E] = Math.min(time[S][E],T);
				time[E][S] = Math.min(time[E][S],T);

			}
			
			for(int i=0; i<W; i++) {
				st = new StringTokenizer(br.readLine());
				
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				time[S][E] = Math.min(time[S][E],-T); 
			}
			
			for(int a=1; a<=N; a++) {
				for(int s=1; s<=N; s++) {
					if(s==a) continue;
					for(int e=1; e<=N; e++) {
						if(s==e || e==a) continue;
						
						if(time[s][e]>time[s][a]+time[a][e]) {
							time[s][e] = time[s][a]+time[a][e];
						}
					}
				}
			}
			
			
			for(int i=1; i<=N; i++) {
				if(time[i][i]<0) {
					System.out.println("YES");
					continue out;
				}
				
				for(int j=1; j<=N; j++) {
					if(i==j) continue;
					if(time[i][j]==987654321 || time[j][i]==987654321) continue;
					if(time[i][j]+time[j][i]<0) {
						System.out.println("YES");
						continue out;
					}
				}
			}
			System.out.println("NO");
		}
		
	}
}
