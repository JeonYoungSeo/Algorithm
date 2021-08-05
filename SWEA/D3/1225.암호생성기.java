import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            sc.nextLine();
            Queue<Integer> queue = new LinkedList<Integer>();
            
            for(int i=0; i<8; i++) {
            	queue.offer(sc.nextInt());
            }
            sc.nextLine();
            
            out : while(true) {
            	for(int i=1; i<6; i++) {
            		int temp = queue.poll();
            		if(temp-i<=0) {
            			queue.offer(0);
            			break out;
            		}
            		queue.offer(temp-i);
            	}
            }
            System.out.print("#"+test_case+" ");
            for(int a : queue) {
            	System.out.print(a+" ");
            }
            System.out.println();
		}
	}
}
