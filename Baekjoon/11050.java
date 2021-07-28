import java.util.Scanner;
import java.math.*;

public class Main{
	
	public static int facto(int n) {
		if(n<=1) return 1;
		
		return n*facto(n-1);
	}
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    			
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	
    	int result = facto(N)/(facto(K)*facto(N-K));
    	
    	System.out.println(result);

    }
}
