import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int count_zero = 0;
	static int count_one = 0;
	static int N ;
	static int[][] paper;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		//색종이 1,0 입력
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//재귀 실행
		scissors(0,0,N,N);
		
		//출력
		bw.write(count_zero+"\n");
		bw.write(count_one+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void scissors(int start_i,int start_j, int end_i, int end_j) {
		//기저 조건
		
		boolean check_zero = true;
		boolean check_one = true;
		
		for(int i=start_i; i<end_i; i++) {
			for(int j=start_j; j<end_j; j++) {
				if(paper[i][j]==1) {
					check_zero = false;
				}else {
					check_one = false;
				}
			}
		}
		
		if(!check_zero && !check_one) {
			int mid_i = (start_i+end_i)/2;
			int mid_j = (start_j+end_j)/2;
			scissors(start_i,start_j,mid_i,mid_j);
			scissors(mid_i,start_j, end_i, mid_j);
			scissors(start_i,mid_j, mid_i, end_j);
			scissors(mid_i,mid_j, end_i, end_j);
		}else {
			if(check_zero) {
				count_zero++;
			}else {
				count_one++;
			}
		}
	}
}
