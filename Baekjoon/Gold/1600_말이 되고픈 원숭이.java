import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-15
 * Description : 백준 1600
 */


public class Main{
  //원숭이 객체 = 좌표와 말처럼뛸수있는 횟수
	public static class Monkey{
		int y,x,k;
		
		Monkey(int y,int x, int k){
			this.y = y;
			this.x = x;
			this.k = k;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int K = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[H][W];
      //방문 배열 - 말처럼뛴횟수마다 따로 체크해주어야지 모두 탐색이 가능하다.
        boolean[][][] visited = new boolean[K+1][H][W];
        
        for(int i=0; i<H; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<W; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        Queue<Monkey> queue = new LinkedList<Monkey>();
        
        queue.add(new Monkey(0,0,K));
        //움직임
        int[] monkey_y = {-1,1,0,0};
        int[] monkey_x = {0,0,1,-1};
        int[] horse_y = {2,1,-2,-1,2,-2,-1,1};
        int[] horse_x = {1,2,-1,-2,-1,1,2,-2};
        
        int count = 0;
      //bfs 사용
        while(!queue.isEmpty()) {
        	int num = queue.size();
        	
        	while(num != 0) {
        		Monkey monkey = queue.poll();
        		int y = monkey.y;
        		int x= monkey.x;
        		int k = monkey.k;
        		
        		if(y==H-1 && x==W-1) {
        			System.out.println(count);
        			return;
        		}
        		
        		for(int i=0; i<4; i++) {
        			int new_y = y+monkey_y[i];
        			int new_x = x+monkey_x[i];
        			if(new_y>=0 && new_y<H && new_x>=0 && new_x<W && !visited[k][new_y][new_x] && board[new_y][new_x]==0) {
        				queue.add(new Monkey(new_y, new_x, k));
        				visited[k][new_y][new_x] = true;
        			}
        		}
        		
        		if(k>0) {
	        		for(int i=0; i<8; i++) {
	        			int new_y = y+horse_y[i];
	        			int new_x = x+horse_x[i];
	        			if(new_y>=0 && new_y<H && new_x>=0 && new_x<W && !visited[k-1][new_y][new_x] && board[new_y][new_x]==0) {
	        				queue.add(new Monkey(new_y, new_x, k-1));
	        				visited[k-1][new_y][new_x] = true;
	        			}
	        		}
        		}
        		
        		num --;
        	}
        	
        	count ++;
        }
        
        System.out.println(-1);
        bw.flush();
        bw.close();
        br.close();
    }
    
}
