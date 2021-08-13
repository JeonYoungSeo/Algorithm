import java.util.*;
import java.io.*;


public class Main {
	static int[][] arr;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st.nextToken();
		
		//N*M배열 생성
		arr = new int[N][M];
		
		
		//원래 배열 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//연산 입력
		st = new StringTokenizer(br.readLine());
		//연산이 없을때 까지 반복
		while(st.hasMoreTokens()) {
			int temp = Integer.parseInt(st.nextToken());
			
			switch(temp) {
			case 1:
				updown();
				break;
			case 2:
				leftright();
				break;
			case 3:
				rightdegree();
				break;
			case 4:
				leftdegree();
				break;
			case 5:
				squareRight();
				break;
			case 6:
				squareLeft();
				break;
			}
			
			
		}
		
		//최종 배열 출력
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
	//상하반전
	private static void updown() {
		for(int i=0; i<arr[0].length; i++){
			for(int j=0; j<arr.length/2; j++) {
				int temp = arr[j][i];
				arr[j][i] = arr[arr.length-j-1][i];
				arr[arr.length-j-1][i] = temp;
			}
		}
	}
	//좌우반전
	private static void leftright() {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr[0].length-j-1];
				arr[i][arr[0].length-j-1] = temp ;
			}
		}
	}
	//오른쪽으로 90도
	private static void rightdegree() {
		//그냥 N과 M을 바꿔줫으면 됫엇습니다 ㅠㅠ..
		int y = arr[0].length; 
		int x = arr.length;
		int[][] arr_temp = new int[y][x]; //임시 배열 생성
		//오른쪽으로 90도
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				arr_temp[j][x-1-i] = arr[i][j] ;
			}
		}
		arr = arr_temp;
	}
	
	private static void leftdegree() {
		int y = arr[0].length; 
		int x = arr.length;
		
		int[][] arr_temp = new int[y][x];
		//왼쪽으로 돌리기
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				arr_temp[y-j-1][i] = arr[i][j] ;
			}
		}
		arr = arr_temp;
	}
	
	//네모모양으로 시계방향으로 회전
	private static void squareRight() {
		int x = arr[0].length; 
		int y = arr.length;
		
		int[][] arr_temp = new int[y][x];
		
		//1번을 2번으로
		for(int i=0; i<y/2; i++) {
			for(int j=0; j<x/2; j++) {
				arr_temp[i][j+x/2] = arr[i][j];
			}
		}
		//2번을 3번으로
		for(int i=0; i<y/2; i++) {
			for(int j=x/2; j<x; j++) {
				arr_temp[i+y/2][j] = arr[i][j];
			}
		}
		
		//3번을 4번으로
		for(int i=y/2; i<y; i++) {
			for(int j=x/2; j<x; j++) {
				arr_temp[i][j-x/2] = arr[i][j];
			}
		}
		
		//4번을 1번으로
		for(int i=y/2; i<y; i++) {
			for(int j=0; j<x/2; j++) {
				arr_temp[i-y/2][j] = arr[i][j];
			}
		}
		
		arr = arr_temp;
	}
	
	//네모모양으로 시계반대방향으로 회전
	private static void squareLeft() {
		int x = arr[0].length; 
		int y = arr.length;
		
		int[][] arr_temp = new int[y][x];
		
		
		//1번을 4번으로
		for(int i=0; i<y/2; i++) {
			for(int j=0; j<x/2; j++) {
				arr_temp[i+y/2][j] = arr[i][j];
			}
		}
		//4번을 3번으로
		for(int i=y/2; i<y; i++) {
			for(int j=0; j<x/2; j++) {
				arr_temp[i][j+x/2] = arr[i][j];
			}
		}
		
		//3번을 2번으로
		for(int i=y/2; i<y; i++) {
			for(int j=x/2; j<x; j++) {
				arr_temp[i-y/2][j] = arr[i][j];
			}
		}
		
		//2번을 1번으로
		for(int i=0; i<y/2; i++) {
			for(int j=x/2; j<x; j++) {
				arr_temp[i][j-x/2] = arr[i][j];
			}
		}
		
		arr = arr_temp;
	}

}

