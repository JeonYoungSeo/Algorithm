import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int t = Integer.parseInt(br.readLine());
        
        for(int i=0; i<t; i++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	int[][] lst = new int[n][n];
        	int num = 1;
        	for(int j=0; j<n; j++) {
        		lst[0][j] = num++;
        	}
	        int y =0;
	        int x =n-1;
	        int[] move_y = {1,0,-1,0};
	        int[] move_x = {0,-1,0,1};
	        int move = 0;
        	for(int j=n-1; j>0; j--) {
        		for(int l=0; l<j; l++) {
        			y += move_y[move];
        			x += move_x[move];
        			lst[y][x]= num++;
        		}
        		move = (move+1)%4;
        		for(int l=0; l<j; l++) {
        			y += move_y[move];
        			x += move_x[move];
        			lst[y][x]= num++;
        		}
        		move = (move+1)%4;
        		
        	}
            bw.write("#"+(i+1)+"\n");
        	for(int[] line : lst) {
        		for(int number : line) {
        			bw.write(number+" ");
        		}
        		bw.newLine();
        	}
        	
        }
    	bw.flush();
        bw.close();
        br.close();
    }
}
