import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // N
		
		int result = facto(N);
			
		bw.write(result+" ");

		bw.flush();
		bw.close();
		br.close();
	}

	private static int facto(int n) {
		if(n==0) return 0; 
				
		int result = 0;
		int temp = n;
		while(temp%5==0) {
			temp /= 5;
			result ++;
		}
		
		return result + facto(n-1);
	}
}
