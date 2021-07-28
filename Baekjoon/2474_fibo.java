import java.util.*;

public class Main{
    static int[] memo = new int[46];
    
    public static int fibo(int n){
        if(n==1) return 1;
        if(n==0) return 0;
        
        if(memo[n]!=0){
            return memo[n];
        }else{
            memo[n] = fibo(n-1)+fibo(n-2);
            return memo[n];
        }
        
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        memo[0] = 0 ;
        memo[1] = 1;
        
        
        int n = sc.nextInt();
        
        System.out.printf("%d",fibo(n));
        
    }
}
