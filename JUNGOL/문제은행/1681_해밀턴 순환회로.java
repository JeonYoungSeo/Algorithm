import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-23
 * Description : JUNGOL 1681
 */


public class Main{
	static int[][] cost;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		cost = new int[N][N];
		visited = new boolean[N];
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0,0,0);
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static int result = 987654321;
	public static void func(int curr, int cnt, int costs) {
		//이미 최저를 넘었으면 탈출
		if(costs>=result) return;
		
		if(cnt==N-1) {
			if(cost[curr][0]==0) return;
			
			result = Math.min(result, costs+cost[curr][0]);
		}
		
		visited[curr] = true;
		for(int i=0; i<N; i++) {
			if(cost[curr][i]==0 || visited[i]==true) continue;
			func(i,cnt+1,costs+cost[curr][i]);
		}
		visited[curr]=false;
	}
}
