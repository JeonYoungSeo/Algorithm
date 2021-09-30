import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//간단한 다익스트라 문제

public class Solution{
	public static class Node implements Comparable<Node>{
		//좌표축, 깊이
		int y,x,d;
		
		Node(int y, int x, int d){
			this.y = y;
			this.x = x;
			this.d = d;
		}

		@Override
		public int compareTo(Node o) {
			return this.d-o.d;
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
        	boolean[][] visited = new boolean[N][N];
        	for(int i=0; i<N; i++) {
        		String str = br.readLine();
        		for(int j=0; j<N; j++) {
        			map[i][j] = str.charAt(j)-'0';
        		}
        	}
        	
        	Queue<Node> que = new PriorityQueue<Node>();  
        	
        	que.add(new Node(0,0,0));
        	
        	while(!que.isEmpty()){
        		
        		Node curr = que.poll();
        		
        		if(curr.y==N-1 && curr.x==N-1) {
        			bw.write("#"+tc+" "+curr.d+"\n");
        			break;
        		}
        		
        		
        		for(int i=0; i<4; i++) {
        			int ny = curr.y + move_y[i];
        			int nx = curr.x + move_x[i];
        			
        			if(ny<0 || ny>=N || nx<0 || nx>=N || visited[ny][nx]) continue;
        			
        			que.add(new Node(ny,nx,curr.d+map[ny][nx]));
        			visited[ny][nx] = true;
        		}
        		
        	}
        }
        
        bw.flush();
        bw.close();
        br.close();	
    }
}
