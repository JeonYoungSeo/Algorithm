import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	static int N,M;
	static int[] tree;
	static long result=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//나무 길이 넣을 배열
		tree = new int[N];
		
		st = new StringTokenizer(br.readLine());
		//int min = Integer.MAX_VALUE;
		int max = 0;
		//입력
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			//min = (min>tree[i])?tree[i]:min;
			max = (max>tree[i])?max:tree[i];
		}
		
		
		//이분탐색을 해보자
		bs(0, max);
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void bs(int left, int right) {
		//기저조건
		if(left == right) {
			int mid = (left+right)/2;
			
			long sum = sum(mid);
			
			if(sum>=M) {
				result = mid;
			}
			return;
		}
		
		int mid = (left+right)/2;
		
		long sum = sum(mid);
		
		if(sum>=M) {
			result = mid;
			bs(mid+1,right);
		}else {
			bs(left, mid);
		}
		
		
		
	}
	
	private static long sum(int num) {
		long sum = 0;
		for(int i=0; i<N; i++) {
			if(tree[i]-num>0) sum+=(tree[i]-num);
		}
		
		return sum;
	}
}
