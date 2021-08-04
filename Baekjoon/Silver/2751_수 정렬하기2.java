import java.io.*;

public class Main {
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int maxn = 2000001;
		
		int[] lst = new int[maxn+1];
		
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			temp += 1000000;
			lst[temp]++;
		}
		
		for(int i=0; i<maxn; i++) {
			if(lst[i] == 1) {
				bw.write((i-1000000)+"\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
