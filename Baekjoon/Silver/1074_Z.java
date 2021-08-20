import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int r,c;
	static long visit_count = 0;
	static boolean find = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //N 입력 
		r = Integer.parseInt(st.nextToken()); //세로
		c = Integer.parseInt(st.nextToken()); //가로
		int size = (int)Math.pow(2, N); //전체 크기 구해줌
		
		visit(N,0,0,size,size); //(몇제곱인지, 시작y,시작x,끝y,끝x)
		
		bw.write(visit_count+" ");//출력
		
		bw.flush();
		bw.close();
		br.close();
	}
	//함수 부분
	private static void visit(int N, int start_y, int start_x,int end_y, int end_x) {
		//기저조건
		if(N==0) {
			return;
		}
		
		//중간 값y,x를 구해준다
		int mid_y = (start_y+end_y)/2;
		int mid_x = (start_x+end_x)/2;
		//quater == 1/4 -> 2의 n제곱을 2번 곱해도 된다 4^n/4 되고 2^(n-1) * 2^(n-1) 
		int quater = (int)Math.pow(4, N-1);
		if(r<mid_y && c<mid_x) {
			//왼쪽위로 가면 시작점은 그대로
			visit(N-1,start_y, start_x, mid_y , mid_x);
		}else if(r<mid_y && c>=mid_x) {
			//오른쪽 위로 가면 quater만큼 지나온것으로 침
			visit_count += quater;
			//그리고 이동한다.
			visit(N-1,start_y, mid_x, mid_y , end_x);
		}else if(r>=mid_y && c<mid_x) {
			//왼쪽 아래로 가면 quater*2만큼 지나온것으로 친다.
			visit_count += quater*2;
			//왼쪽 아래로
			visit(N-1,mid_y, start_x, end_y , mid_x);
		}else if(r>=mid_y && c>=mid_x) {
			//오른쪽 아래로 가면 quater*3만큼 지나온것으로 친다.
			visit_count += quater*3;
			//오른쪽 아래로 이동
			visit(N-1,mid_y, mid_x, end_y , end_x);
		}
			
	}
}
