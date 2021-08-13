import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int N,M,D;
	static int count;
	static BufferedWriter bw;
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		//격자판 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] board_copy = new int[N][M];
		//격자판 저장
		for(int k=0; k<N; k++) {
			for(int j=0; j<M; j++) {
				board_copy[k][j] = board[k][j];
			}
		}
		
		//결과값
		int result = 0;
		//궁수배치를 구하기 위해 x의 길이만큼 진행
	fir : for(int i=1; i<=1<<M; i++) {
 			int archer[] =new int[3]; //궁수 위치 배열
			int archer_n =0; //궁수의 수 (최대3명)
			for(int j=0; j<M; j++) {
				if((i & (1<<j))!=0) { //해당자리에 배치하고싶어
					archer_n++; //증가
					if(archer_n>3) continue fir; //궁수 3명 넘으면 패스
					archer[archer_n-1] = j; //궁수 위치 저장
				}
			}
			if(archer_n <3) continue; //궁수 3명 안되면 패스
			
			//3명일때만 통과
			//격자판 초기화
			for(int k=0; k<N; k++) {
				for(int j=0; j<M; j++) {
					board[k][j] = board_copy[k][j];
				}
			}
			
			count = 0; //잡은 횟수 초기화
			
			for(int k=0; k<N; k++) { //세로축 횟수만큼 진행 (어차피 얼마 안돼)
				attack(archer);
				//bw.write(count+"\n");
			}
			
			result = Math.max(count,result); //큰 수 저장

		}
		
		bw.write(result+" ");
		
		bw.flush();
		bw.close();
		br.close();
	}
	//공격하자
	private static void attack(int[] arch) throws IOException{ 
		
		boolean check = true;
		
	out : for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j] != 0) {
					check = false;
					break out ;
				}
			}
		}
		if(check) return;
		
		
		
		int kill[][] = new int[3][2]; //죽일 자리 저장 
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				kill[i][j] = -1;
			}
		}
		
		for(int i=0; i<3; i++) { //3명의 궁수가 공격
			int dis = 987654321;
			for(int y=0; y<N; y++) { //아래 위치부터
				if(y<0)break;
				for(int x=0; x<M; x++) { //왼쪽부터 (가장 왼쪽잇는애 잡아야해)
					if(board[y][x] == 1) {
						int range = (int)Math.abs(N-y)+(int)Math.abs(arch[i]-x);
						if(D<range) continue;
						if(dis>=range){
							if(dis>range) {
								dis = range;
								kill[i][0] = y;
								kill[i][1] = x;
							}else {
								if(kill[i][1] > x) {
									kill[i][0] = y;
									kill[i][1] = x;
								}
							}
						}
						
					}
					
					
				}
			}
		}
		//잡을 위치 다 정햇다 
		//쏘자 똑같은 놈들 고려해서
		for(int i=0; i<3; i++) {
			if(kill[i][0] <0) continue;
			if(board[kill[i][0]][kill[i][1]] == 1) { //이미 잡앗으면 안늘어
				count++;
				board[kill[i][0]][kill[i][1]] = 0;
			}
		}
		
		//한칸 내리기
		
		boardDown();
		
		//후 다 내려올때까지 반복
		
	}
	
	private static void boardDown() {
		for(int y=N-1; y>0; y--) {
			for(int x=0; x<M; x++) {
				board[y][x] = board[y-1][x];
			}
		}
		for(int x=0; x<M; x++) {
			board[0][x] = 0;
		}
	}
}




