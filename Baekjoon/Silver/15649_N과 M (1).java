import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] lst = {1,2,3,4,5,6,7,8};
	static List<Integer> input = new ArrayList<Integer>();
	static boolean[] isSelected;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException{

				
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isSelected = new boolean[N+1];
		permutation(M);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static void permutation(int m) throws IOException {
		if(m == 0) {
			print();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[lst[i]]) continue;
			input.add(lst[i]);
			isSelected[lst[i]] = true;
			permutation(m-1);
			input.remove(input.size()-1);
			isSelected[lst[i]] = false;
		}
		
		return;
		
	}

	
	static void print() throws IOException {
		for(int i=0; i< input.size(); i++) {
			bw.write(input.get(i)+" ");
		}
		bw.newLine();
	}
}
