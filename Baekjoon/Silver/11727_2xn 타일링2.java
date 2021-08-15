import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int memo[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine()); // N
		memo = new int[1001];
		memo[1] = 1;
		memo[2] = 3;
		int total_count = tiling(N);
			
		bw.write(total_count+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}

	private static int tiling(int n) {
		//기저 조건
		if(n==1) {
			return memo[1];
		}else if(n==2) {
			return memo[2];
		}
		
		if(memo[n]!=0) return memo[n];
		
		memo[n] = (tiling(n-1)+(tiling(n-2)*2))%10007;
		
		return memo[n];
	}
}
