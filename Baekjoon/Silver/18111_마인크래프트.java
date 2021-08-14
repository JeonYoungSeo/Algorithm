import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, B;
	static int[][] field;
	static int dig_t = 2;
	static int set_t = 1;
	static int min=Integer.MAX_VALUE, max = 0; ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //세로
		M = Integer.parseInt(st.nextToken()); //가로
		B = Integer.parseInt(st.nextToken()); //block
		//랜선 길이 넣을 배열
		field = new int[N][M];
		
		//블럭입력
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
		
				min = (min>field[i][j])?field[i][j] : min;
				max = (max>field[i][j])?max : field[i][j];
			}
		}
		int result_time= Integer.MAX_VALUE;
		int result_floor = 0;
		for(int i=min; i<=max; i++) {
			int temp = time(i);
			
			if(temp<=result_time) {
				result_time = temp;
				result_floor = i;
			}
		}
		
		
		bw.write(result_time+" "+result_floor);
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int time(int num) {
		int block_n = B;
		int result = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int temp = num - field[i][j]; //필요한 갯수
				block_n -= temp;
				result += (temp<0)?-temp*dig_t : temp*set_t;
			}
		}
		if(block_n>=0) {
			return result;
		}else {
			return Integer.MAX_VALUE;
		}
	}
}
