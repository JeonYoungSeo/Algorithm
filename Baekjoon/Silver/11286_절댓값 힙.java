import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-30
 * Description : 백준 11286
 */

public class Main{
	static int[] heap;
	static int num = 0;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		int N = Integer.parseInt(br.readLine())+1;
		heap = new int[N+1];
		for(int i=1; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n!=0) {
				heap[++num] = n;
				min_heap(num);
			}else {
				if(heap[1]==0) {
					bw.write(0+"\n");
				}else {
					bw.write(heap[1]+"\n");
					heap[1] = heap[num--];
					if(num == 0)
						heap[num+1] = 0;
					min_heap2(1);
				}
			}
		}
		
		
		bw.flush();
		bw.close();
		br.close();
			
	}
	
	public static void min_heap(int num) {
		if(num<=1) return;
		
		int n1 = Math.abs(heap[num]);
		int n2 = Math.abs(heap[num/2]);
		
		
		if(n1 < n2) {
			int temp = heap[num];
			heap[num] = heap[num/2];
			heap[num/2] = temp;
			min_heap(num/2);
		}else if(n1 == n2) {
			if(heap[num] < heap[num/2]) {
				int temp = heap[num];
				heap[num] = heap[num/2];
				heap[num/2] = temp;
				min_heap(num/2);
			}
		}
		
		return;
	}
	
	public static void min_heap2(int n) {
		if(n>num) return;
		
		if(n*2 <=num && n*2+1 > num) {
			int n1 = Math.abs(heap[n]);
			int n2 = Math.abs(heap[n*2]);
			
			if(n1 > n2) {
				int temp = heap[n];
				heap[n] = heap[n*2];
				heap[n*2] = temp;
				min_heap2(n*2);
			}else if(n1 == n2) {
				if(heap[n] > heap[n*2]) {
					int temp = heap[n];
					heap[n] = heap[n*2];
					heap[n*2] = temp;
					min_heap(n*2);
				}
			}
			return;
			
		}else if(n*2 <=num && n*2+1 <= num) {
			int n1 = Math.abs(heap[n]);
			int n2 = Math.abs(heap[n*2]);
			int n3 = Math.abs(heap[n*2+1]);
			if(n2<n3) {
				if(n1 > n2) {
					int temp = heap[n];
					heap[n] = heap[n*2];
					heap[n*2] = temp;
					min_heap2(n*2);
				}else if(n1 == n2) {
					if(heap[n] > heap[n*2]) {
						int temp = heap[n];
						heap[n] = heap[n*2];
						heap[n*2] = temp;
						min_heap(n*2);
					}
				}
				return;
			}else if(n2>n3){
				if(n1 > n3) {
					int temp = heap[n];
					heap[n] = heap[n*2+1];
					heap[n*2+1] = temp;
					min_heap2(n*2+1);
				}else if(n1 == n3) {
					if(heap[n] > heap[n*2+1]) {
						int temp = heap[n];
						heap[n] = heap[n*2+1];
						heap[n*2+1] = temp;
						min_heap(n*2);
					}
				}
				return;
			}else if(n2==n3) {
				if(heap[n*2]<heap[n*2+1]) {
					if(n1 > n2) {
						int temp = heap[n];
						heap[n] = heap[n*2];
						heap[n*2] = temp;
						min_heap2(n*2);
					}else if(n1 == n2) {
						if(heap[n] > heap[n*2]) {
							int temp = heap[n];
							heap[n] = heap[n*2];
							heap[n*2] = temp;
							min_heap(n*2);
						}
					}
					return;
				}else {
					if(n1 > n3) {
						int temp = heap[n];
						heap[n] = heap[n*2+1];
						heap[n*2+1] = temp;
						min_heap2(n*2+1);
					}else if(n1 == n3) {
						if(heap[n] > heap[n*2+1]) {
							int temp = heap[n];
							heap[n] = heap[n*2+1];
							heap[n*2+1] = temp;
							min_heap(n*2);
						}
					}
					return;
				}
			}
		}
	}
}
