import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static long[] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(br.readLine());
		
		int curr = n-1;
		
		while(curr-->0) {
			if(sb.charAt(curr)=='A') {
				if(sb.charAt(curr+1)=='A') {
					sb.replace(curr, curr+2, "A");
					continue;
				}
				if(sb.charAt(curr+1)=='G') {
					sb.replace(curr, curr+2, "C");
					continue;
				}
				if(sb.charAt(curr+1)=='C') {
					sb.replace(curr, curr+2, "A");
					continue;
				}
				if(sb.charAt(curr+1)=='T') {
					sb.replace(curr, curr+2, "G");
					continue;
				}
			}
			
			if(sb.charAt(curr)=='G') {
				if(sb.charAt(curr+1)=='A') {
					sb.replace(curr, curr+2, "C");
					continue;
				}
				if(sb.charAt(curr+1)=='G') {
					sb.replace(curr, curr+2, "G");
					continue;
				}
				if(sb.charAt(curr+1)=='C') {
					sb.replace(curr, curr+2, "T");
					continue;
				}
				if(sb.charAt(curr+1)=='T') {
					sb.replace(curr, curr+2, "A");
					continue;
				}
			}
			
			if(sb.charAt(curr)=='C') {
				if(sb.charAt(curr+1)=='A') {
					sb.replace(curr, curr+2, "A");
					continue;
				}
				if(sb.charAt(curr+1)=='G') {
					sb.replace(curr, curr+2, "T");
					continue;
				}
				if(sb.charAt(curr+1)=='C') {
					sb.replace(curr, curr+2, "C");
					continue;
				}
				if(sb.charAt(curr+1)=='T') {
					sb.replace(curr, curr+2, "G");
					continue;
				}
			}
			
			if(sb.charAt(curr)=='T') {
				if(sb.charAt(curr+1)=='A') {
					sb.replace(curr, curr+2, "G");
					continue;
				}
				if(sb.charAt(curr+1)=='G') {
					sb.replace(curr, curr+2, "A");
					continue;
				}
				if(sb.charAt(curr+1)=='C') {
					sb.replace(curr, curr+2, "G");
					continue;
				}
				if(sb.charAt(curr+1)=='T') {
					sb.replace(curr, curr+2, "T");
					continue;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
