import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> lst = new ArrayList<Integer>();
		
		for(int i=1; i<=N; i++) {
			lst.add(i);
		}
		
		int turn = K-1;
		bw.write("<");
		bw.write(Integer.toString(lst.get(turn)));
		lst.remove(turn);
		N--;
		if(N != 0 ) {
			turn = ((turn-1+K)/N>0)? (turn-1+K)%N : (turn-1+K) ;
		}
		
		while(N!=0) {
			bw.write(", "+lst.get(turn));
			lst.remove(turn);
			N--;
			if(N==0) break;
			turn = ((turn-1+K)/N>0)? (turn-1+K)%N : (turn-1+K) ;
		}
		bw.write(">");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
