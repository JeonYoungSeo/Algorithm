import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int[] H = new int[9];
        
        for(int i=0; i<9; i++) H[i] = sc.nextInt();
        
        while(true){
        	Random rand = new Random();
        	for(int i=0;  i<7; i++) {
        		int temp = rand.nextInt(9);
        		int temp2 = H[i];
        		H[i] = H[temp];
        		H[temp] = temp2;
        	}
        	
        	int sum = 0;
        	for(int i=0; i<7; i++) sum+=H[i];
        	
        	if(sum==100) {
        		sort(H);
        		for(int i=0; i<7; i++) System.out.println(H[i]);
        		return;
        	}
        }
    }
    
    static private void sort(int[] H) {
    	for(int i=0; i<6; i++) {
    		for(int j=0; j<6-i; j++) {
    			if(H[j]>H[j+1]) {
    				int temp = H[j];
    				H[j] = H[j+1];
    				H[j+1] = temp;
    			}
    		}
    	}
    }
}
