import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		//맵 입력
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		int result = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'L') {
					boolean[][] visited = new boolean[R][C];
					result = Math.max(BFS(i,j,visited), result);
				}
			}
		}
		
		System.out.println(result);
	}

	static int[] my = {1,-1,0,0};
	static int[] mx = {0,0,1,-1};
	
	private static int BFS(int y, int x, boolean[][] visited) {
		
		Queue<int[]> que = new LinkedList<>();
		
		que.add(new int[] {y,x});
		visited[y][x]= true;
		int result = 0;
		
		while(!que.isEmpty()) {
			int cnt = que.size();
			
			while(cnt-->0) {
				int[] curr = que.poll();
				
				for(int i=0; i<4; i++) {
					int ny = curr[0]+my[i];
					int nx = curr[1]+mx[i];
					
					if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
					
					if(!visited[ny][nx] && map[ny][nx]=='L') {
						que.add(new int[] {ny,nx});
						visited[ny][nx] = true;
					}
				}
			}
			result++;
		}
	    
		
		return result-1;
	}
}
