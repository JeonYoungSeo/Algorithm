import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-29
 * Description : 백준 5430
 */

public class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//tc	
		int T = Integer.parseInt(br.readLine());
		
	out : for(int t=0; t<T; t++) {
			//뒤집어졌는지 여부
			boolean R = false;
			//수행 순서
			StringBuilder sb = new StringBuilder(br.readLine());
			//배열 길이
			int N = Integer.parseInt(br.readLine())+1;
			//배열 받아와서 [] 자르고 ,로 구분하여 저장
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str.substring(1,str.length()-1), ",");
			int[] arr = new int[N];
			//입력
			for(int i=1; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			//속도 줄이기 위해 Arrays.remove()사용하지 않고 범위 표현
			int start = 1;
			int end = N-1;
			
			int curr = 0;
			while(sb.length() != curr) {
				char func = sb.charAt(curr);
				curr++;
				//뒤집어졌는지 여부
				if(func=='R') {
					if(R) R=false;
					else R=true;
					continue;
				}
				//뒤집어졌는지에따라 앞과 뒤중 하나를 줄여준다
				if(func=='D') {
          //길이가 -가 되면 error출력하고 continue;
					if(start > end) {
						bw.write("error\n");
						continue out;
					}
					if(R) {
						end--;
					}else {
						start++;
					}
				}
				
			}
			//출력 부분
			bw.write("[");
			if(R) {//뒤부터 출력
				for(int i=end; i>start; i--) {
					bw.write(arr[i]+",");
				}
				if(end < start) {
					bw.write("]\n");
				}else {
					bw.write(arr[start]+"]\n");
				}
			}else {//앞부터 출력
				for(int i=start; i<end; i++) {
					bw.write(arr[i]+",");
				}
				if(end < start) {
					bw.write("]\n");
				}else {
					bw.write(arr[end]+"]\n");
				}
			}
			
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

