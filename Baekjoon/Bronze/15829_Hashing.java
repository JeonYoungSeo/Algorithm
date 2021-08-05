import java.io.*;
import java.math.*;
public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String ln = br.readLine();
		
		BigInteger result = new BigInteger("0");
	
		for(int i=0; i<N; i++) {
			BigInteger temp = new BigInteger(Integer.toString((int)ln.charAt(i)-96));
			BigInteger n31 = new BigInteger("31");
			
			n31 = n31.pow(i).multiply(temp).mod(new BigInteger("1234567891"));
			result = result.add(n31).mod(new BigInteger("1234567891"));
		}
		
		bw.write(result.toString());
			
		bw.flush();
		bw.close();
		br.close();
	}
}
