import java.io.*;
import java.util.*;


public class Solution{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			
			LinkedList<Integer> lst = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				lst.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<M; i++) {
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for(int j=0; j<count; j++) {
					lst.add(idx++, Integer.parseInt(st.nextToken()));
				}
			}
            bw.write("#"+test_case+" ");
			for(int i=0; i<10; i++) {
				bw.write(lst.get(i)+" ");
			}
			bw.newLine();

		}
        bw.flush();
        bw.close();
        br.close();
	                
	}
}
