import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		N--;
		sb.append(br.readLine());
		
		while(N-->0) {
			StringBuilder comp = new StringBuilder(br.readLine());
			int i = -1;
			while(++i<comp.length()) {
				if(sb.charAt(i) != comp.charAt(i)) {
					sb.setCharAt(i, '?');
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}
}
