import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static long memo[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // N
		memo = new long[101];
		memo[1] = 1;
		memo[2] = 1;
		memo[3] = 1;
		memo[4] = 2;
		memo[5] = 2;
		
		for(int i=0; i<N; i++) {
			long result = P(Integer.parseInt(br.readLine()));
			
			bw.write(result+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static long P(int n) {
		if(n<6) return memo[n];
		
		if(memo[n] != 0) {
			return memo[n];
		}
		
		memo[n] = P(n-1) + P(n-5);

		return memo[n];
	}
}
