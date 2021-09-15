import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	static int C,R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[C+2][R+2];
        for(int i=1; i<=C; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=R; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        //치즈 갯수 세주는 함수
        int count = count_c(board);
        int hour = 0;
        //없어질때까지 반복
        while(true) {
	        //0,0에서 공기 퍼뜨리기 공기 = -1 
	        air(board,0,0);
	        
	        //치즈(1)가 공기(-1)와 2면 이상 접촉해있으면 녹인다
	        melt(board);
	        hour ++;
	        //다시 공기 제거 
	        remove_air(board);
	        
	        if(count_c(board)==0) break;
	        
	        //후 다시 공기 채워 넣음
	        air(board,0,0);
	        
	        count = count_c(board);
        }
        
        bw.write(hour+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int count_c(int[][] board) {
    	int count = 0;
    	for(int i=1; i<=C; i++) {
    		for(int j=1; j<=R; j++) {
    			if(board[i][j]==1) count++;
    		}
    	}
    	return count;
    }
    
    static int[] move_y = {1,-1,0,0};
	static int[] move_x = {0,0,1,-1};
    
    public static void air(int[][] board,int y, int x) {
    	
    	if(board[y][x]==0) {
    		board[y][x]=-1;
    	}
    	
    	for(int i=0; i<4; i++) {
    		int new_y = y+move_y[i];
    		int new_x = x+move_x[i];
    		
    		if(new_y>=0 && new_y<C+2 && new_x>=0 && new_x<R+2 && board[new_y][new_x]==0) {
    			air(board,new_y,new_x);
    		}
    	}
    	
    	
    }
    
    public static void melt(int[][] board) {
    	for(int i=1; i<=C; i++) {
    		for(int j=1; j<=R; j++) {
    			if(board[i][j] == 1) {
    				int count = 0;
    				for(int k=0; k<4; k++) {
    					int y = i+move_y[k];
    					int x = j+move_x[k];
    					
    					if(board[y][x] == -1) {
    						count ++;
    					}
    					if(count>=2) {
    						board[i][j] = 0;
    					}
    				}
    			}
    		}
    	}
    }
    
    public static void remove_air(int[][] board) {
    	for(int i=0; i<C+2; i++) {
    		for(int j=0; j<R+2; j++) {
    			if(board[i][j]==-1) board[i][j] = 0;
    		}
    	}
    }
}
