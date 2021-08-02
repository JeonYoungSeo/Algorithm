package practice;

import java.io.*;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
	
	private static void hanoiwithprint(int n,int start, int mid, int dest) throws IOException {
		if(n==1) {
			bw.write(start+" "+dest+"\n");
			return;
		}
		
		
		hanoiwithprint(n-1, start, dest, mid);
		
		bw.write(start+" "+dest+"\n");
		
		hanoiwithprint(n-1, mid,start, dest);
	}
	
	static int count = 0 ;
	private static void hanoi(int n,int start, int mid, int dest) throws IOException {
		if(n==1) {
			count ++;
			return ;
		}
		
		hanoi(n-1, start, dest, mid);
		
		count ++;
		
		hanoi(n-1, mid,start, dest);
		
		return;
	}
	
	
    public static void main(String[] args) throws IOException {
        
        int N = Integer.parseInt(br.readLine());
        
        if(N<=20) {
        	hanoi(N,1,2,3);
        	bw.write(Integer.toString(count));
        	bw.newLine();
        	hanoiwithprint(N,1,2,3);
        }else {
        	hanoi(N,1,2,3);
        	bw.write(Integer.toString(count));
        	bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
   
}
