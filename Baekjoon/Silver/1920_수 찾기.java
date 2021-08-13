import java.util.*;
import java.io.*;

public class Main {
	static BufferedWriter bw;
	static int[] lst;
	static int N ;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		lst = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//입력
		for(int i=0; i<N; i++) {
			lst[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(lst);
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			//구현 함수
			search(temp,0, N-1);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void search(int n,int left, int right) throws IOException {
		//기저조건 찾앗을때와 없을때  
		if(n == lst[(left+right)/2]) {
			bw.write("1\n");
			return;
		}
		if(left==right) {
			bw.write("0\n");
			return;
		}
		
		//중간값보다 작을때
		int mid =(left+right)/2;
		if(lst[mid] > n) {
			search(n,left, mid);
		}else {
			search(n,mid+1, right);
		}
		
	}
}
