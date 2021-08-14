import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int K,N;
	static long[] lan;
	static long result=1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		//랜선 길이 넣을 배열
		lan = new long[N];
		
		//int min = Integer.MAX_VALUE;
		long max = 0;
		//입력
		for(int i=0; i<K; i++) {
			lan[i] = Long.parseLong(br.readLine());
			//min = (min>tree[i])?tree[i]:min;
			max = (max>lan[i])?max:lan[i];
		}
		
		//이분탐색을 해보자
		bs(1, max);
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void bs(long left, long right) {
		//기저조건
		if(left == right) {
			long mid = (left+right)/2;
			
			long sum = sum(mid);
			
			if(sum>=N) {
				result = mid;
			}
			return;
		}
		
		long mid = (left+right)/2;
		
		long sum = sum(mid);
		
		if(sum>=N) {
			result = mid;
			bs(mid+1,right);
		}else {
			bs(left, mid);
		}
	}
	
	private static long sum(long num) {
		long sum = 0;
		for(int i=0; i<N; i++) {
			sum += (lan[i]/num);
		}
		return sum;
	}
}
