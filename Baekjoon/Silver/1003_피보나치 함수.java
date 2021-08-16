import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int count_zero[], count_one[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			
			count_one = new int[41];
			count_zero = new int[41];
			fibonacci(temp);

			bw.write(count_zero[temp]+" "+count_one[temp]+"\n");
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void fibonacci(int n) {
		if(count_zero[n]!=0 || count_one[n]!=0) {
			return ;
		}
		
		if(n==0) {
			count_zero[n]++;
			return ;
		}else if(n==1) {
			count_one[n]++;
			return ;
		}
		
		if(count_zero[n]!=0 || count_one[n]!=0) {
			return ;
		}
		
		fibonacci(n-1);
		fibonacci(n-2);
		count_zero[n] = (count_zero[n-1]+count_zero[n-2]);
		count_one[n] = (count_one[n-1]+count_one[n-2]);
	}
}
