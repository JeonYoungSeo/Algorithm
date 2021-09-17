import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[][] comb = new long[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0 || j==i) {
					comb[i][j] = 1;
					continue;
				}
				comb[i][j] = comb[i-1][j-1]+comb[i-1][j];
			}
		}

		bw.write(comb[n][m]+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
