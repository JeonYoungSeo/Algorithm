import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-16
 * Description : 백준 9205
 */


public class Main{
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] addr = new int[n+2][2];
			StringTokenizer st;
			//집 주소 입력
			st = new StringTokenizer(br.readLine());
			addr[0][1] = Integer.parseInt(st.nextToken());
			addr[0][0] = Integer.parseInt(st.nextToken());
			
			//편의점 주소 입력
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				addr[i][1] = Integer.parseInt(st.nextToken());
				addr[i][0] = Integer.parseInt(st.nextToken());
			}
			
			//페스티벌 주소 입력
			st = new StringTokenizer(br.readLine());
			addr[n+1][1] = Integer.parseInt(st.nextToken());
			addr[n+1][0] = Integer.parseInt(st.nextToken());
			
			//각 정점간의 거리 
			int[][] leng = new int[n+2][n+2];
			
			for(int i=0; i<n+2; i++) {
				for(int j=0; j<n+2; j++) {
					if(i==j) continue;
					
					leng[i][j] = Math.abs(addr[j][0]-addr[i][0])+Math.abs(addr[j][1]-addr[i][1]);
					
					if(leng[i][j] > 1000) leng[i][j] = 987654321;
				}
			}
			//플로이드-와샬 적용
			for(int k=0; k<n+2; k++) {
				for(int i=0; i<n+2; i++) {
					if(i==k) continue;
					for(int j=0; j<n+2; j++) {
						if(j==i || j==k) continue;
						
						leng[i][j] = Math.min(leng[i][j], leng[i][k]+leng[k][j]);
					}
				}
			}
			if(leng[0][n+1]==987654321) {
				bw.write("sad\n");
			}else {
				bw.write("happy\n");
			}

		}
		bw.flush();
		bw.close();
		br.close();
	}
}
