import java.io.*;

public class Main {
	static int sum;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{

		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i=0; i<test_case; i++) {
			sum=0;
			int n = Integer.parseInt(br.readLine());
			
			int result = recur(n);
			
			bw.write(result+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static private int recur(int n) throws IOException {
		//기저조건
		if(sum==n) return 1;
		if(sum>n) return 0;
		
		int result = 0;
		
		for(int i=1; i<4; i++) {
			sum+=i;
			result += recur(n);
			sum-=i;
		}
		
		return result;
		
	}
}
