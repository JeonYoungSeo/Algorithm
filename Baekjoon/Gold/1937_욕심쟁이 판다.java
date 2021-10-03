import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
* dfs로 풀이하였다. 들어갈수 있는 깊이를 visited배열에 체크해주었고
* 이미 갔던곳이면 다시 계산할 필요가 없게 메모이제이션을 사용해주었다. 
*/
public class Main {
	static int[][] map;
	static int[][] visited;
	static int n ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new int[n][n];
			
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = -1;
			}
		}
		
		int result = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				result = Math.max(dfs(i,j),result);
			}
		}
		
		System.out.println(result);

	}
	
	static int[] my = {1,-1,0,0};
	static int[] mx = {0,0,-1,1};
	
	private static int dfs(int y, int x) {
		
		if(visited[y][x]!=-1) return visited[y][x];
		
		int result = 1;
		int add = 0;
		
		for(int i=0; i<4; i++) {
			int ny = y+my[i];
			int nx = x+mx[i];
			
			if(ny<0 || ny>=n || nx<0 || nx>=n) continue;
			
			if(map[ny][nx]>map[y][x]) {
				add = Math.max(dfs(ny,nx),add);
			}
		}
		result += add;
		visited[y][x] = result;
		return result;
	}

}
