import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] people = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			people[i][0] = Integer.parseInt(st.nextToken());
			people[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int result = 1 ;
			for(int j=0 ;j<N; j++) {
				if(i==j) continue;
				
				if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
					result ++;
				}
			}
			
			bw.write(result+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
