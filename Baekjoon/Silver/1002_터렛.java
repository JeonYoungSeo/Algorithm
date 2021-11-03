import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			
			if(x1==x2 && y1==y2 && r1==r2) {
				System.out.println(-1);
				continue;
			}
			
			if((r1+r2)*(r1+r2) == (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)) {
				System.out.println(1);
			}else if((r2-r1)*(r2-r1) == (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)) {
				System.out.println(1);
			}else if((r2+r1)*(r2+r1) < (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)) {
				System.out.println(0);
			}else if((r2-r1)*(r2-r1) > (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)) {
				System.out.println(0);
			}else {
				System.out.println(2);
			}
			
		}
		
	}
}
