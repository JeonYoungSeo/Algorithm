import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-29
 * Description : 백준 6064
 */

public class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//테스트 케이스
		int t = Integer.parseInt(br.readLine());
		
	out : for(int tc = 0; tc<t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 입력값 입력
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int rx=x;
			int ry=x;
			while(rx>M)
				rx-=M;
			while(ry>N)
				ry-=N;
			int count = x;
			while(true) {
        //정답 조건
				if(rx==x && ry==y) break;
        //우선 하나의 조건이라도 만족해야 하기에 rx에 기준을 맞춰서 x가 되게 횟수를 늘려주었다.
        count += M;
				rx+=M;
				ry+=M;
				while(rx>M)
					rx-=M;
				while(ry>N)
					ry-=N;
				//세상이 끝나는 해
				if(count>M*N) {
					System.out.println(-1);
					continue out;
				}
			}
			System.out.println(count);
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
