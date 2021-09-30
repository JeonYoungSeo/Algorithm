import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
    static int[] my = {1,0,-1,0};
    static int[] mx = {0,1,0,-1};
    static int[][] map;
    static boolean[][] visited;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());

        
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	int R = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	int L = Integer.parseInt(st.nextToken());
        	
        	map = new int[N][M];
        	visited = new boolean[N][M];
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<M; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	Queue<int[]> que = new LinkedList<int[]>();
        	
        	que.add(new int[] {R,C});
        	visited[R][C] = true;
        	int cnt = 0;
        	while(!que.isEmpty()) {
        		int num = que.size();
        		if(L==0) break;
        		while(num-->0) {
        			int[] curr = que.poll();
        			cnt ++;
        			//하 우 상 좌
        			switch(map[curr[0]][curr[1]]) {
        			case 1 :
        				int[] m1 = {0,1,2,3};
        				search(que, m1, curr[0], curr[1]);
        				break;
        			case 2 :
        				int[] m2 = {0,2};
        				search(que, m2, curr[0], curr[1]);
        				break;
        			case 3 :
        				int[] m3 = {1,3};
        				search(que, m3, curr[0], curr[1]);
        				break;
        			case 4 : 
        				int[] m4 = {1,2};
        				search(que, m4, curr[0], curr[1]);
        				break;
        			case 5 :
        				int[] m5 = {0,1};
        				search(que, m5, curr[0], curr[1]);
        				break;
        			case 6 : 
        				int[] m6 = {0,3};
        				search(que, m6, curr[0], curr[1]);
        				break;
        			case 7 :
        				int[] m7 = {2,3};
        				search(que, m7, curr[0], curr[1]);
        				break;
        			}
        		}
        		L--;
        	}
        	bw.write("#"+tc+" "+cnt+"\n");
        }
        
        bw.flush();
        bw.close();
        br.close();	
    }

	private static void search(Queue<int[]> que, int[] move, int y, int x) {
		for(int i : move) {
			int ny = y+my[i];
			int nx = x+mx[i];
			
			if(ny<0 || ny>=N || nx<0 || nx>=M || visited[ny][nx]) continue;
			
			int check = map[ny][nx];
			
			if(check!=0) {
				//하 우 상 좌
				//하
				if(i==0 && (check==3||check==5||check==6)) continue;
				//우
				if(i==1 && (check==2||check==4||check==5)) continue;
				//상
				if(i==2 && (check==3||check==4||check==7)) continue;
				//좌
				if(i==3 && (check==2||check==6||check==7)) continue;
				
				que.add(new int[] {ny,nx});
				visited[ny][nx] = true;
			}
		}
	}
}
