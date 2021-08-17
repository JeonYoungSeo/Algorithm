import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Ref implements Comparable<Ref>{
		int min, max ;
		
		public Ref(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}
		
		@Override
		public int compareTo(Ref o) {
			int value = this.max - o.max;
			if(value != 0) return value; 
			
			return this.min - o.min;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Ref[] ref = new Ref[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			ref[i] = new Ref(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(ref);
		
		
		//for(int i=0; i<ref.length; i++) {
		//	System.out.println(ref[i].min+" "+ref[i].max);
		//}
		int cnt = 0;
		for(int i=0; i<ref.length; i++) {
			cnt++;
			int temp = i+1;
			while(temp<ref.length && ref[i].max >= ref[temp].min) {
				temp++;
			}
			i = temp-1;
			
		}
		System.out.println(cnt);
	}
	

}
