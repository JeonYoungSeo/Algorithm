import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        List<Integer> lst = new ArrayList<Integer>();
        
        int N = sc.nextInt();
        sc.nextLine();
        
        for(int i=1; i<=N; i++) {
        	int num = sc.nextInt();
        	
        	lst.add(lst.size()-num,i);
        }
        
        for(int num : lst) {
        	System.out.print(num+" ");
        }
        
    }
}
