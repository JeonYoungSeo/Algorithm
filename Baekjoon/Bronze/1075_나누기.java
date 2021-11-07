import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());

		int result = 99;
		
		int temp = N+1;
		while(temp%100!=0) {
			if(temp%F==0) {
				result = Math.min(result, temp%100);
			}
			temp++;
		}
		
		temp = N-1;
		while(temp>=0 && temp%100!=99) {
			if(temp%F==0) {
				result = Math.min(result, temp%100); 
			}
			temp--;
		}

		if(N%F==0) {
			result = Math.min(result, N%100); 
		}
		
		System.out.println((result<10)?"0"+Integer.toString(result):result);
	}
}
