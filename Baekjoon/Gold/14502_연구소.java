import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-17
 * Description : 백준 14502
 */


public class Main{
	static int N,M;
	static int[][] labo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	  //세로 가로 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		labo = new int[N][M]; //연구소
		//입력값
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				labo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		putWall(0,0,0);
		
		bw.write(result+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
  
	static int result = 0; //결과물
  //벽 설치 매개변수 : 설치한 벽 갯수, 마지막으로 설치한 벽의 좌표(y,x)
	public static void putWall(int n,int y, int x) {
		if(n==3) {
      //벽 3개 설치했으면 갯수를 구해 최댓값을 찾아준다.
			result = Math.max(result, virus());
			return ;
		}
    
    //전에 설치한 벽의 위치부터 시작.
		boolean once = true;
		for(int i=0; i<N; i++) {
			if(once) i=y; 
			for(int j=0; j<M; j++) {
				if(once) {
					j=x;
					once=false;
				}
				if(labo[i][j] == 0) {
					labo[i][j] = -1;
					putWall(n+1,i,j);
					labo[i][j] = 0;
				}
			}
		}
	}
	
	static int[] move_y = {1,-1,0,0};
	static int[] move_x = {0,0,1,-1};
	//바이러스 확산 후, 안전지대 파악, 원래대로 되돌리기
	public static int virus() {
		//DFS적용
		Queue<int[]> queue = new LinkedList<int[]>();
		//처음 바이러스 위치만 넣어준다.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(labo[i][j] == 2) {
					queue.add(new int[] {i, j});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for(int i=0; i<4; i++) {
				int new_y = curr[0]+move_y[i];
				int new_x = curr[1]+move_x[i];
				//범위 한정
				if(new_y<0 || new_y>=N || new_x<0 || new_x>=M) continue;
				//빈 공간이면 바이러스는 3으로 퍼진다.
				if(labo[new_y][new_x] == 0) {
					queue.add(new int[] {new_y,new_x});
					labo[new_y][new_x] = 3;
				}
			}
		}
    //안전지대 세어준다.
		int result = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(labo[i][j] == 0) result++;
			}
		}
		//3을 제거해주면 원래 있던 바이러스인 2만 남는다.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(labo[i][j] == 3) labo[i][j] = 0;
			}
		}
		//안전지대 갯수 리턴.
		return result;
	}
}
