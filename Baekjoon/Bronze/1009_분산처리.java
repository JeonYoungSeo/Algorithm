import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		// 1 : 1
		// 2 : 2 4 8 6
		// 3 : 3 9 7 1 
		// 4 : 4 6 
		// 5 : 5
		// 6 : 6
		// 7 : 7 9 3 1
		// 8 : 8 4 2 6 
		// 9 : 9 1 
		
		int[] arr2 = {6,2,4,8};
		int[] arr3 = {1,3,9,7};
		int[] arr7 = {1,7,9,3};
		int[] arr8 = {6,8,4,2};
		int[] arr4 = {6,4};
		int[] arr9 = {1,9};
		
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			a %= 10;
			if(a==1 || a==5 || a==6 || a==0) {
				System.out.println((a==0)?10:a);
				continue;
			}
			
			if(a==4) {
				System.out.println(arr4[b%2]);
			}
			if(a==9) {
				System.out.println(arr9[b%2]);
			}
			if(a==2) {
				System.out.println(arr2[b%4]);
			}
			if(a==3) {
				System.out.println(arr3[b%4]);
			}
			if(a==7) {
				System.out.println(arr7[b%4]);
			}
			if(a==8) {
				System.out.println(arr8[b%4]);
			}
			
			
			
			
			
		}
	}
}
