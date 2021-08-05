import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int k=0; k<N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int[] stu = new int[M];
			int sum = 0;
			for(int i=0; i<M; i++) {
				stu[i] = Integer.parseInt(st.nextToken());
				sum += stu[i];
			}
			double avg = sum/M;
			
			int count = 0;
			for(int j=0; j<M; j++) {
				if(avg<stu[j]) count++;
			}
				
			
			bw.write(String.format("%.3f", (double)count/M*100)+"%\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
