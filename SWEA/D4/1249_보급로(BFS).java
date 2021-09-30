import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution{
	public static class Node{
		int y,x,d;

		public Node(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        int[] move_y = {1,-1,0,0};
        int[] move_x = {0,0,-1,1};
        
        for(int tc=1; tc<=T; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	int[][] map = new int[N][N];
        	int[][] leng = new int[N][N];
        	for(int i=0; i<N; i++) {
        		Arrays.fill(leng[i], Integer.MAX_VALUE);
        	}
        	boolean[][] visited = new boolean[N][N];
        	for(int i=0; i<N; i++) {
        		String str = br.readLine();
        		for(int j=0; j<N; j++) {
        			map[i][j] = str.charAt(j)-'0';
        		}
        	}
        	
        	Queue<Node> que = new LinkedList<Node>();
        	
        	que.add(new Node(0,0,0));
        	while(!que.isEmpty()) {
        		Node curr = que.poll();
        		
                if(curr.d > leng[curr.y][curr.x]) continue;
                
        		for(int i=0; i<4; i++) {
        			int ny = curr.y+move_y[i];
        			int nx = curr.x+move_x[i];
        			
        			if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
        			
        			int nl = curr.d+map[ny][nx];
        			
        			if(nl<leng[ny][nx]) {
        				leng[ny][nx] = nl;
        				que.add(new Node(ny, nx, nl));
        			}
        		}
        	}
        	
			bw.write("#"+tc+" "+leng[N-1][N-1]+"\n");
        	
        }
        
        bw.flush();
        bw.close();
        br.close();	
    }
}
