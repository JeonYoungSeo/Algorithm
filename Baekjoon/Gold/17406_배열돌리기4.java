import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int r,c,s;
	static int[] start_i ;
	static int[] start_j;
	static int[] end_i ;
	static int[] end_j ;
	static int R;

	static int[] isselected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int [][]arr = new int[N][M];
		//배열 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		start_i = new int[R];
		start_j= new int[R];
		end_i = new int[R];
		end_j = new int[R];
		isselected = new int[R];
		
		
		for(int i=0; i<R; i++) {
			st= new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			
			start_i[i] = r-s-1;
			start_j[i] = c-s-1;
			end_i[i] = r+s-1;
			end_j[i] = c+s-1;
		}
		//돌리자
		int result = recur(arr,0);
		
		//출력
		
		bw.write(Integer.toString(result));
		
		bw.flush();
		bw.close();
		br.close();
	}
	private static int what_min(int[][] arr) {
		int result = Integer.MAX_VALUE;
		for(int[] line : arr) {
			int sum=0;
			for(int num : line) {
				sum+=num;
			}
			result = (result>sum)?sum: result;
		}
		
		return result;
	}
	
	private static void show(int[][] arr) {
		for(int[] line:arr) {
			for(int a: line) {
				System.out.print(a+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	private static int recur(int[][] arr, int i) {
		//기저 조건
		if(i>=R) {
			return what_min(arr);
		}
		
		int result = Integer.MAX_VALUE ;
		
		for(int num=0; num<R; num++) {
			if(isselected[num] == 1) continue;
			int start1=start_i[num];
			int start2 = start_j[num];
			int end1 = end_i[num];
			int end2 = end_j[num];
			
			while(true) {
				if(start1>=start1+(end1-start1)/2 || start2>=start2+(end2-start2)/2) break;
				turn(arr, start1, start2, end1, end2);
				start1++;
				start2++;
				end1--;
				end2--;
			}

			
			//show(arr);
			
			isselected[num] = 1;
			result = Integer.min(recur(arr,i+1), result);
			isselected[num] = 0;

			start1=start_i[num];
			start2 = start_j[num];
			end1 = end_i[num];
			end2 = end_j[num];
			
			while(true) {
				if(start1>=start1+(end1-start1)/2 || start2>=start2+(end2-start2)/2) break;
				turn_rev(arr, start1, start2, end1, end2);
				start1++;
				start2++;
				end1--;
				end2--;
			}
		
			
			//show(arr);
			
		}
		return result;
	}
	
	
	
	//돌리는 함수
	private static void turn(int[][] arr,int start_i, int start_j,int end_i, int end_j) {
		int[] move_y = {1, 0, -1, 0 };
		int[] move_x = {0, 1, 0 , -1 };
		int curr = 0;
		int i = start_i;
		int j = start_j;
		
		while(true) {
			if(curr == 4) break;
			
			if(i+move_y[curr]<start_i || i+move_y[curr]>end_i || j+move_x[curr]<start_j || j+move_x[curr]>end_j) {
				curr++;
				continue;
			}
			
			int temp = arr[i][j];
			arr[i][j] = arr[i+move_y[curr]][j+move_x[curr]];
			arr[i+move_y[curr]][j+move_x[curr]] = temp;
			i += move_y[curr];
			j += move_x[curr];
		}
		
		int temp = arr[start_i][start_j] ;
		arr[start_i][start_j] = arr[start_i][start_j+1];
		arr[start_i][start_j+1] = temp;
	}
	//원상복귀 ㅠㅠ
	private static void turn_rev(int[][] arr,int start_i, int start_j,int end_i, int end_j) {
		int[] move_y = {0, 1, 0, -1 };
		int[] move_x = {1, 0, -1,0 };
		int curr = 0;
		int i = start_i;
		int j = start_j;
		
		while(true) {
			if(curr == 4) break;
			
			if(i+move_y[curr]<start_i || i+move_y[curr]>end_i || j+move_x[curr]<start_j || j+move_x[curr]>end_j) {
				curr++;
				continue;
			}
			
			int temp = arr[i][j];
			arr[i][j] = arr[i+move_y[curr]][j+move_x[curr]];
			arr[i+move_y[curr]][j+move_x[curr]] = temp;
			i += move_y[curr];
			j += move_x[curr];
		}
		
		int temp = arr[start_i][start_j] ;
		arr[start_i][start_j] = arr[start_i+1][start_j];
		arr[start_i+1][start_j] = temp;
	}

}

