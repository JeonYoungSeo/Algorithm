import java.io.*;

public class Main {
	
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] count = new int[8002];
		int sum = 0;
		int max = -4001;
		int min = 4001;
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			count[temp+4000]++;
			sum += temp;
			max = (max<temp)?temp:max;
			min = (min>temp)?temp:min;
		}
		
		bw.write(String.format("%.0f \n",(double)sum/N));
		
		int median = 0 ;
		for(int i=0; i<8002; i++) {
			if(count[i]>=1) {
				median += count[i];
			}
			if(median>=((N/2)+1)) {
				median = i;
				break;
			}
		}
		
		int count_max = 0;
		int count_max2 = 0;
		for(int i=8001; i>=0; i--) {
			if(count[count_max]<=count[i]) {
				count_max2 = count_max;
				count_max = i;
			}
		}
		
		bw.write(median-4000+"\n");
		bw.write(((count[count_max] == count[count_max2])?count_max2-4000:count_max-4000) + "\n");
		bw.write(max-min+"\n");
		  
		bw.flush();
		bw.close();
		br.close();
	}
}
		
	
