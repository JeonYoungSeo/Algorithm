import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int C,R;
	
	public static class Person{
		int y,x,k;
		
		Person(int y,int x, int k){
			this.y = y;
			this.x = x;
			this.k = k;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean day = true;
        
        int[][] board = new int[H][W];
        boolean[][][] visited = new boolean[K+1][H][W];
        
        for(int i=0; i<H; i++) {
        	String str = br.readLine();
        	for(int j=0; j<W; j++) {
        		board[i][j] = str.charAt(j)-'0';
        	}
        }
        
        Queue<Person> queue = new LinkedList<Person>();
        
        queue.add(new Person(0,0,0));
        //움직임
        int[] move_y = {-1,1,0,0};
        int[] move_x = {0,0,1,-1};
        
        int count = 1;
        while(!queue.isEmpty()) {
        	int num = queue.size();
        	
        	while(num != 0) {
        		Person person = queue.poll();
        		int y = person.y;
        		int x = person.x;
        		int k = person.k;
        		
        		if(y==H-1 && x==W-1) {
        			System.out.println(count);
        			return;
        		}
        		
        		for(int i=0; i<4; i++) {
        			int new_y = y+move_y[i];
        			int new_x = x+move_x[i];
        			if(new_y>=0 && new_y<H && new_x>=0 && new_x<W && !visited[k][new_y][new_x] && board[new_y][new_x]==0) {
        				queue.add(new Person(new_y, new_x, k));
        				visited[k][new_y][new_x] = true;
        			}
        		}
        		
        		if(k!=K) {
        			k++;
	        		for(int i=0; i<4; i++) {
	        			int new_y = y+move_y[i];
	        			int new_x = x+move_x[i];
	        			if(new_y>=0 && new_y<H && new_x>=0 && new_x<W && board[new_y][new_x]==1 && !visited[k][new_y][new_x] && day) {
	        				queue.add(new Person(new_y, new_x, k));
	        				visited[k][new_y][new_x] = true;
	        				visited[k][y][x] = true;
	        				
	        			}
	        		}
        		}
            //밤에만 대기
        		if(!day) {
        			queue.add(person);
        		}
        		num --;
        	}
          //밤낮 
        	day = !day;
        	count ++;
        }
        
        System.out.println(-1);
        bw.flush();
        bw.close();
        br.close();
    }
    
}
