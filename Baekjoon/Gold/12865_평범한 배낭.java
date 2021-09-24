import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-24
 * Description : 백준 12865
 */


public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] able = new int[K+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			// 현재 값과 넣은값 + 현재물건의 가치 중 큰 것을 넣어준다.
			for(int j=K; j>=W; j--) {
				able[j] = Math.max(able[j], able[j-W]+V);
			}
		}
		
		bw.write(able[K]+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
