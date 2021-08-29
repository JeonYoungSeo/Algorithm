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
 * Date : 2021-08-29
 * Description : 백준 7569
 */

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//높이 가로 세로 크기 입력
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		//상자 생성
		int[][][] box = new int[H][N][M];
		//이 문제는 너비 우선 탐색으로 풀어야 한다. 
		//bfs위한 큐 생성
		Queue<int[]> queue = new LinkedList<int[]>();
		//방문 배열 생성
		boolean[][][] visited = new boolean[H][N][M];
		
		//상자 입력
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					box[h][i][j] = Integer.parseInt(st.nextToken());
					
					if(box[h][i][j]==1) {
						queue.add(new int[] {h, i, j});
						visited[h][i][j] = true;
					}
				}
			}
		}
		int result = -1;
		
		int[] my = {1,0,-1,0};
		int[] mx = {0,1,0,-1};
		//큐 끝날때까지 반복
		while(!queue.isEmpty()) {
			int size = queue.size();
			result ++;
			while(size!=0) {
				//원소 하나 뽑고 사이즈 --
				int[] temp = queue.poll();
				size --;
				
				int h = temp[0];
				int y = temp[1];
				int x = temp[2];
				
				box[h][y][x] = 1;
				//상하좌우 확인
				for(int i=0; i<4; i++) {
					int temp_y = y+my[i];
					int temp_x = x+mx[i];
					
					if(temp_y>=0 && temp_x>=0 && temp_y<N && temp_x<M && !visited[h][temp_y][temp_x] && box[h][temp_y][temp_x]==0) {
						queue.add(new int[] {h,temp_y,temp_x});
						visited[h][temp_y][temp_x] = true;
					}
				}
				//위 아래층 확인 
				if(h-1>=0 && !visited[h-1][y][x] && box[h-1][y][x]==0) {
					queue.add(new int[] {h-1,y,x});
					visited[h-1][y][x] = true;
				}
				if(h+1<H && !visited[h+1][y][x] && box[h+1][y][x]==0) {
					queue.add(new int[] {h+1,y,x});
					visited[h+1][y][x] = true;
				}
				
			}

		}
		
		boolean check = false;
		//결과 확인
	out : for(int h=0; h<H; h++) { 
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(box[h][i][j] == 0) {
						check = true;
						break out;
					}
				}
			}
		}
		if(check)
			System.out.println(-1);
		else
			System.out.println(result);
		bw.flush();
		bw.close();
		br.close();
	}
}



