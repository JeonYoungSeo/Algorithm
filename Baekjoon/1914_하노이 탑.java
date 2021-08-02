import java.io.*;
import java.math.BigInteger;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
	
	private static void hanoi(int n,int start, int mid, int dest) throws IOException {
		if(n==1) {
			bw.write(start+" "+dest+"\n");
			return;
		}
		hanoi(n-1, start, dest, mid);
		
		bw.write(start+" "+dest+"\n");
		
		hanoi(n-1, mid,start, dest);
	}
	
    public static void main(String[] args) throws IOException {
        
        int N = Integer.parseInt(br.readLine());
        BigInteger count = new BigInteger("2");
        
        count = count.pow(N);
        count = count.subtract(new BigInteger("1"));
        
        if(N<=20) {
        	bw.write(count.toString());        
        	bw.newLine();
        	hanoi(N,1,2,3);
        }else {
        	bw.write(count.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
