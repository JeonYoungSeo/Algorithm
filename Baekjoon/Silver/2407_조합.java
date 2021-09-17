import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-17
 * Description : 백준 2407
 */


public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger num1 = BigInteger.valueOf(n);
		BigInteger num2 = BigInteger.ONE;
		// n! / (n-r)!*r! 공식 사용
		for(int i=1; i<m; i++) {
			num1 = num1.multiply(BigInteger.valueOf(n-i));
			num2 = num2.multiply(BigInteger.valueOf(i+1));
		}
		
		bw.write(num1.divide(num2).toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}
