import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int r,c;
	static long visit_count = -1;
	static boolean find = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int size = (int)Math.pow(2, N);
		
		visit(N,0,0,size,size);
		
		bw.write(visit_count+" ");
		
		bw.flush();
		bw.close();
		br.close();
	}
	private static void visit(int N, int start_y, int start_x,int end_y, int end_x) {
		
		if(N==0) {
			visit_count++;
			if(start_y==r && start_x==c) {
				find = true;
			}
			return;
		}
		
		
		int mid_y = (start_y+end_y)/2;
		int mid_x = (start_x+end_x)/2;
		int quater = (int)Math.pow(4, N-1);
		if(r<mid_y && c<mid_x) {
			visit(N-1,start_y, start_x, mid_y , mid_x);
		}else if(r<mid_y && c>=mid_x) {
			visit_count += quater;
			visit(N-1,start_y, mid_x, mid_y , end_x);
		}else if(r>=mid_y && c<mid_x) {
			visit_count += quater*2;
			visit(N-1,mid_y, start_x, end_y , mid_x);
		}else if(r>=mid_y && c>=mid_x) {
			visit_count += quater*3;
			visit(N-1,mid_y, mid_x, end_y , end_x);
		}
			
	}
}
