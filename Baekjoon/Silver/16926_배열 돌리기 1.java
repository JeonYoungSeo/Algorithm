import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		//배열 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int start_i=0;
		int start_j=0;
		//돌리기 실행
		while(true) {
			if(start_i>=N/2 || start_j>=M/2) break;
			for(int r=0; r<R; r++) {
				turn(start_i, start_j);				
			}
			start_i++;
			start_j++;
		}
		
		//출력
		
		for(int[] line : arr) {
			for(int num : line) {
				bw.write(num+" ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	

	static int[] move_y = {0, 1, 0, -1};
	static int[] move_x = {1, 0,-1,0};
	
	//돌리는 함수
	private static void turn(int start_i, int start_j) {
		int curr = 0;
		int i = start_i;
		int j = start_j;
		
		while(true) {
			if(curr == 4) break;
			
			if(i+move_y[curr]<start_i || i+move_y[curr]>=N-start_i || j+move_x[curr]<start_j || j+move_x[curr]>=M-start_j) {
				curr++;
				continue;
			}
			
			int temp = arr[i][j];
			arr[i][j] = arr[i+move_y[curr]][j+move_x[curr]];
			arr[i+move_y[curr]][j+move_x[curr]] = temp;
			i += move_y[curr];
			j += move_x[curr];
		}
		
		int temp = arr[i][j] ;
		arr[i][j] = arr[i+1][j];
		arr[i+1][j] = temp;
	}

}

