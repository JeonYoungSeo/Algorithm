import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//사무실 크기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//사무실 생성
		char[][] office = new char[N][M];
		//사무실 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				office[i][j] = st.nextToken().charAt(0);
			}
		}
		//함수 실행
		camera(office,0,0);
		
		System.out.println(min_square);
	}		
  //이동방향
	static int[] dir_y = {1,0,-1,0};
	static int[] dir_x = {0,1,0,-1};
  //출력물
	static int min_square = Integer.MAX_VALUE;
	//함수 구현
	public static void camera(char[][] office, int y, int x) {
    //기저조건 : 끝에 도달하였다.
		if(y>=N-1 && x>=M-1) {
      //0의 갯수 찾아 최소값 저장
			int count=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(office[i][j]=='0') count++;
					if(count>min_square) return;
				}
			}
			
			min_square = (min_square>count)?count:min_square;
			return;
		}
    //x줄끝까지 가면 다음줄로
		if(x>=M) {
			y++;
			x=0;
		}
    //카메라 만날때까지 탐색
		while(office[y][x] == '0' || office[y][x] == '6'||office[y][x] == '#') {
			if(y>=N-1 && x>=M-1) {
				int count=0;
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						if(office[i][j]=='0') count++;
						if(count>min_square) return;
					}
				}
				
				min_square = (min_square>count)?count:min_square;
				return;
			}
			
			x++;
			if(x>=M) {
				y++;
				x=0;
			}
		}
		
		
		//각각 카메라의 동작 실현
		switch(office[y][x]) {
		case '1' : 
			for(int i=0; i<4; i++) {
				camera(check1(office,y,x,i), y,x+1);
			}
			break;
		case '2' :
			for(int i=0; i<2; i++) {
				camera(check2(office,y,x,i), y,x+1);
			}
			break;
		case '3' :
			for(int i=0; i<4; i++) {
				camera(check3(office,y,x,i), y,x+1);
			}
			break;
		case '4' :
			for(int i=0; i<4; i++) {
				camera(check4(office,y,x,i), y,x+1);
			}
			break;
		case '5' :
			camera(check5(office,y,x), y,x+1);
		}
				
	}
	
	public static char[][] check1(char[][] temp,int y, int x,int dir){
		char[][] office = new char[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				office[i][j] = temp[i][j];
			}
		}
		
		while(true) {
			y += dir_y[dir];
			x += dir_x[dir];
			
			if(y<0 || x<0 || y>=N || x>=M || office[y][x] == '6') break;
			
			if(office[y][x]=='0') office[y][x] = '#';
		}
		
		return office;
	}
	
	public static char[][] check2(char[][] temp,int y, int x,int dir){
		char[][] office = new char[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				office[i][j] = temp[i][j];
			}
		}
		
		for(int i=0; i<2; i++) {
			int temp_y = y;
			int temp_x = x;
			while(true) {
				temp_y += dir_y[(dir+(i*2))%4];
				temp_x += dir_x[(dir+(i*2))%4];
				
				if(temp_y<0 || temp_x<0 || temp_y>=N || temp_x>=M || office[temp_y][temp_x] == '6') break;
				
				if(office[temp_y][temp_x]=='0') office[temp_y][temp_x] = '#';
			}
		}
		return office;
	}
	
	public static char[][] check3(char[][] temp,int y, int x,int dir){
		char[][] office = new char[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				office[i][j] = temp[i][j];
			}
		}
		
		for(int i=0; i<2; i++) {
			int temp_y = y;
			int temp_x = x;
			while(true) {
				temp_y += dir_y[(dir+i)%4];
				temp_x += dir_x[(dir+i)%4];
				
				if(temp_y<0 || temp_x<0 || temp_y>=N || temp_x>=M || office[temp_y][temp_x] == '6') break;
				
				if(office[temp_y][temp_x]=='0') office[temp_y][temp_x] = '#';
			}
		}
		
		return office;
	}
	public static char[][] check4(char[][] temp,int y, int x,int dir){
		char[][] office = new char[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				office[i][j] = temp[i][j];
			}
		}
		
		for(int i=0; i<3; i++) {
			int temp_y = y;
			int temp_x = x;
			while(true) {
				temp_y += dir_y[(dir+i)%4];
				temp_x += dir_x[(dir+i)%4];
				
				if(temp_y<0 || temp_x<0 || temp_y>=N || temp_x>=M || office[temp_y][temp_x] == '6') break;
				
				if(office[temp_y][temp_x]=='0') office[temp_y][temp_x] = '#';
			}
		}
		
		return office;
	}
	
	public static char[][] check5(char[][] temp,int y, int x){
		char[][] office = new char[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				office[i][j] = temp[i][j];
			}
		}
		
		for(int i=0; i<4; i++) {
			int temp_y = y;
			int temp_x = x;
			while(true) {
				temp_y += dir_y[i];
				temp_x += dir_x[i];
				
				if(temp_y<0 || temp_x<0 || temp_y>=N || temp_x>=M || office[temp_y][temp_x] == '6') break;
				
				if(office[temp_y][temp_x]=='0') office[temp_y][temp_x] = '#';
			}
		}
		
		return office;
	}
}
