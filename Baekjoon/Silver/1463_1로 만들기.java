import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); //N입력
		int[] arr = new int[1000001];
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		for(int i=4; i<=N; i++) {
			arr[i] = Integer.MAX_VALUE;
			for(int j=1; j<=3; j++) {
				int temp = i;
				if(j==1) {
					temp --;
					arr[i] = Math.min(1+arr[temp],arr[i]);
				}else if(j==2 && i%2==0) {
					temp /= 2;
					arr[i] = Math.min(1+arr[temp],arr[i]);
				}else if(j==3 && i%3==0) {
					temp /= 3;
					arr[i] = Math.min(1+arr[temp],arr[i]);
				}
			}
		}
		
		bw.write(Integer.toString(arr[N]));
		bw.flush();
		bw.close();
		br.close();
	}
}
