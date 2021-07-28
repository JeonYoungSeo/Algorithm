import java.util.*;

public class Main{
    static int facto(int n){
        if(n<=1) return 1;
        
        return n*facto(n-1);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        System.out.println(facto(N));
    }
}
