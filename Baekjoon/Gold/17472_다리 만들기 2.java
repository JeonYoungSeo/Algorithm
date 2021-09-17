import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-17
 * Description : 백준 17472
 */


public class Main{
	static int N,M;
	static int[][] leng;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//섬의 번호 붙이기
		int num = 2;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j] == 1) {
					numbering(board, i, j, num);
					num++;
				}
			}
		}
		num-=2;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j] !=0) {
					board[i][j]--;
				}
			}
		}
		
		
		//섬 연결시킬수 있는 다리 길이 저장해보자
		//만들수 있는 다리 길이 저장
		leng = new int[num+1][num+1];
		for(int i=1; i<=num ; i++) {
			Arrays.fill(leng[i], 987654321);
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j] != 0) {
					measure(board,i,j);
				}
			}
		}
		
		//전부 갈수있는지 확인 
		//갈수있는 배열, 몇번째 섬인지, 현재까지 길이, 누적 연결섬갯수
		for(int i=0; i<=num; i++) {
			for(int j=0; j<=num; j++) {
				if(leng[i][j] == 987654321) leng[i][j] = 0;
			}
		}
    //임시 출력
//		for(int[] line : leng) { 
//			for(int n : line) {
//				bw.write(n+" ");
//			}
//			bw.newLine();
//		}
//		bw.newLine();
		int result = visitCheck(leng);
		
		
//		//임시 출력확인
//		for(int[] line : board) {
//			for(int n : line) {
//				bw.write(n+" ");
//			}
//			bw.newLine();
//		}
//		bw.newLine();
		if(result!=987654321) {
			bw.write(result+"\n");
		}else {
			bw.write("-1\n");
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] move_y = {1,-1,0,0};
	static int[] move_x = {0,0,1,-1};
	
	public static void numbering(int[][] board,int y, int x, int num) {
		
		board[y][x] = num;
		
		for(int i=0; i<4; i++) {
			int new_y = y+move_y[i];
			int new_x = x+move_x[i];
			
			if(new_y < 0 || new_y>=N || new_x<0 || new_x>=M) continue;
			
			if(board[new_y][new_x] == 1) {
				numbering(board,new_y,new_x,num);
			}
		}
	}
	
	//다리 최소 길이 측정
	public static void measure(int[][] board, int y, int x) {
		//4방향 0 인지 탐색
		for(int i=0; i<4; i++) {
			int new_y = y+move_y[i];
			int new_x = x+move_x[i];
			int len = 0;
			
			if(new_y < 0 || new_y>=N || new_x<0 || new_x>=M || board[new_y][new_x]!=0) continue;
			
			while(true) {
				new_y += move_y[i];
				new_x += move_x[i];
				len++;
				if(new_y < 0 || new_y>=N || new_x<0 || new_x>=M) break;
				
				if(board[new_y][new_x]!=0) {
					if(len==1) break;
					leng[board[y][x]][board[new_y][new_x]] = Math.min(len, leng[board[y][x]][board[new_y][new_x]]);
					leng[board[new_y][new_x]][board[y][x]] = Math.min(len, leng[board[y][x]][board[new_y][new_x]]);
					break;
				}
			}
		}
	}
	
	
	//갈수있는 배열
	public static int visitCheck(int[][] leng) {
		int N = leng.length-1;
		
		int[] len = new int[N+1];
		Arrays.fill(len,987654321);
		
		boolean[] visited = new boolean[N+1];
		
		len[1] = 0;
		
		int result = 0;
		
		for(int i=0; i<N; i++) {
			//최솟값 찾기
			int min = 987654321;
			int curr = 0;
			for(int j=1; j<=N; j++) {
				if(!visited[j] && min>len[j]) {
					min = len[j];
					curr = j;
				}
			}
			if(min == 987654321) return min;
			result += min;
			visited[curr] = true;
			
			for(int j=1; j<=N; j++) {
				if(!visited[j] && leng[curr][j]!=0 && len[j] > leng[curr][j]) {
					len[j] = leng[curr][j];
				}
			}
		}
		
		return result;
		
	}
}
