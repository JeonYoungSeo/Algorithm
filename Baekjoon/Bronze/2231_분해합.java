import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int count = 1;
		for(int i=1 ; i<=6; i++) {
			if((N / (int)Math.pow(10, i)) != 0) count++;
			else break;
		}
		
		int start_num = 0;
		
		for(int i=0; i<count; i++) {
			start_num += 9;
		}
		
		int result = 0;
		for(int i=N-start_num; i<N; i++) {
			if(i<0) {
				i = -1;
				continue;
			}
			
			int temp = i;
			
			for(int j=0; j<count; j++) {
				temp += (i/(int)Math.pow(10, j))%10;
			}
			if(temp == N) {
				result = i;
				break;
			}
		}
		
		bw.write(Integer.toString(result));
		
		bw.flush();
		bw.close();
		br.close();
	}
}

