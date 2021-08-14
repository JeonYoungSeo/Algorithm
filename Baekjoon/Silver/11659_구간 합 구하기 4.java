import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //줄의 개수
		int M = Integer.parseInt(st.nextToken()); //합구해야하는 횟수
		
		int[] numbers = new int[N+1];
		st = new StringTokenizer(br.readLine());
		//숫자 입력
		numbers[1] = Integer.parseInt(st.nextToken());
		for(int i=2; i<=N; i++) {
			numbers[i] = numbers[i-1]+Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); 
			int end = Integer.parseInt(st.nextToken());
			
			if(start==1) {
				bw.write(numbers[end]+"\n");
			}else {
				bw.write(numbers[end]-numbers[start-1]+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	
	}
}
