import java.io.IOException;
import java.util.Scanner;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-24
 * Description : 백준 1292
 */

public class Main{
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		//1~1000까지 배열 미리 구함
		int[] arr = new int[1001];
		
		int count =0; 
		int n = 1;
		for(int i=1; i<1001; i++) {
			if(count == n) {
				count = 0;
				n++;
			}
			arr[i] = n;
			count++;
		}
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = 0;
    //a~b까지 더해주자
		for(int i=a; i<=b; i++) sum+=arr[i];
		//출력
		System.out.println(sum);
	}
}
