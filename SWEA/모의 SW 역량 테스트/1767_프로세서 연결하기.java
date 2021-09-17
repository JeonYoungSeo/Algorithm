import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-17
 * Description : SWEA 1767
 */


public class Main{
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			int[][] board = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = result = 0;
			connect(board,1,0,0,0);
			
			bw.write("#"+tc+" "+result+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int max,result;
	static int[] move_y = {1,-1,0,0};
	static int[] move_x = {0,0,-1,1};
	public static void connect(int[][] board, int y, int x,int len,int num) {
		boolean once = true;
		for(int i=0; i<N; i++) {
			if(i==0 || i==N-1) continue;
			for(int j=0; j<N; j++) {
				if(once) {
					i=y;
					j=x;
					once = false;
					continue;
				}
				if(j==0 || j==N-1) continue;
				
				if(board[i][j] == 1) {
					
					for(int k=0; k<4; k++) {
						int new_y=i, new_x=j;
						int count = 0;
						boolean check = true;
						while(true) {
							new_y += move_y[k];
							new_x += move_x[k];
							
							if(new_y==-1 || new_y==N || new_x==-1 || new_x==N) {
								break;
							}
							
							if(board[new_y][new_x]!=0) {
								check = false;
								break;
							}else {
								board[new_y][new_x]=2;
								count++;
							}
						}
						
						if(check) {
							if(max<num+1) {
								result = len+count;
								max = num+1;
							}else if(max == num+1) {
								result = Math.min(result, len+count);
							}
							connect(board,i,j,len+count,num+1);
						}
						while(true) {
							new_y -= move_y[k];
							new_x -= move_x[k];
							
							if(new_y == i && new_x == j) break;
							
							if(board[new_y][new_x]==2) {
								board[new_y][new_x]=0;
							}
						}
					}
					
				}
				
				
			}
		}
		
		
	}
}
