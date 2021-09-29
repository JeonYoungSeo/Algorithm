import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-29
 * Description : 백준 4485
 * 가장 적은 루피를 잃어야 하므로 다익스트라 알고리즘을 사용하였다. 
 */


public class Main{
	public static class Node implements Comparable<Node>{
		int y,x,leng;
		
		Node(int y, int x, int leng){
			this.y = y;
			this.x = x;
			this.leng = leng;
		}
    //leng을 기준으로 poll
		@Override
		public int compareTo(Node o) {
			return this.leng-o.leng;
		}
	}
	
	static int[][] cave,leng;
	static boolean[][] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int count = 1;
        while(true) {
	    	int N = Integer.parseInt(br.readLine());
	    	if(N==0) {
	            bw.flush();
	            bw.close();
	            br.close();
	    		return;
	    	}
	    	//동굴,방문배열 생성
	    	cave = new int[N][N];
	    	visited = new boolean[N][N];
	    	leng = new int[N][N];
	    	
	    	for(int i=0; i<N; i++) {
	    		Arrays.fill(leng[i], Integer.MAX_VALUE);
	    	}
	    	//동굴 정보 입력
	    	for(int i=0; i<N; i++) {
	    		StringTokenizer st = new StringTokenizer(br.readLine());
	    		for(int j=0; j<N; j++) {
	    			cave[i][j] = Integer.parseInt(st.nextToken());
	    		}
	    	}
	    	//우선순위 큐 생성
	    	PriorityQueue<Node> queue = new PriorityQueue<Node>();
	    	//첫 노드 삽입
	    	leng[0][0] = cave[0][0];
	    	queue.add(new Node(0,0,leng[0][0]));
	    	//사방탐색
	    	int[] move_y = {1,-1,0,0};
	    	int[] move_x = {0,0,-1,1};
	    	
	    	while(!queue.isEmpty()) {
	    		Node curr = queue.poll();
	    		//재방문 하지 않음
	    		if(visited[curr.y][curr.x]) continue;
	    		//방문처리
	    		visited[curr.y][curr.x] = true;
	    		//끝에 도달했으면 출력
	    		if(curr.y==N-1 && curr.x==N-1) {
	    			bw.write("Problem "+count+": "+curr.leng+"\n");
	    			count++;
	    			break;
	    		}
	    		//사방탐색 실행
	    		for(int i=0; i<4; i++) {
	    			int new_y = curr.y+move_y[i];
	    			int new_x = curr.x+move_x[i];
	    			//범위내, 방문하지 않았다면
	    			if(new_y<0 || new_y>=N || new_x<0 || new_x>=N || visited[new_y][new_x]) continue;
	    			//지금까지의 잃은 루피 + 새로운 노드의 루피
	    			queue.add(new Node(new_y,new_x,curr.leng+cave[new_y][new_x]));
	    		}
	    	}
        }

    }
}
