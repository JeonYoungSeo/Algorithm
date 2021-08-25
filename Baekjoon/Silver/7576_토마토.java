/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-25
 * Description : 백준 7576
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//가로 세로 크기 입력
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		//상자 생성
		int[][] box = new int[N][M];
		//이 문제는 너비 우선 탐색으로 풀어야 한다. 
		//bfs위한 큐 생성
		Queue<int[]> queue = new LinkedList<int[]>();
		//방문 배열 생성
		boolean[][] visited = new boolean[N][M];
		
		//상자 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				if(box[i][j]==1) {
					queue.add(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		
		int result = -1;
		
		int[] my = {1,0,-1,0};
		int[] mx = {0,1,0,-1};
		//1로만들면서 bfs 진행
		while(!queue.isEmpty()) {
			int size = queue.size();
			result ++;
			while(size!=0) {
				int[] temp = queue.poll();
				size --;
				
				int y = temp[0];
				int x = temp[1];
				
				box[y][x] = 1;
				
				for(int i=0; i<4; i++) {
					int temp_y = y+my[i];
					int temp_x = x+mx[i];
					
					if(temp_y>=0 && temp_x>=0 && temp_y<N && temp_x<M && !visited[temp_y][temp_x] && box[temp_y][temp_x]==0) {
						queue.add(new int[] {temp_y,temp_x});
						visited[temp_y][temp_x] = true;
					}
				}
			}

		}
		
		boolean check = false;
    //0이 하나라도 있으면 -1 아니면 결과 출력		
		out : for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 0) {
					check = true;
					break out;
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

