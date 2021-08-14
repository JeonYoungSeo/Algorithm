import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[2002];
		
		for(int i=0; i<N; i++) {
			numbers[Integer.parseInt(br.readLine())+1000]++;
		}
		
		for(int i=0; i<2002; i++) {
			if(numbers[i] == 1) {
				System.out.println(i-1000);
			}
		}
	}
}
