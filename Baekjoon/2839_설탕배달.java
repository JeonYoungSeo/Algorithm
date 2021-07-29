import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int K = sc.nextInt();
        int minimum = 987654321;
        for(int i=0; i<=K/5; i++){
            for(int j=0; j<=K/3; j++){
                if(5*i+3*j==K){
                    if(minimum>i+j) {
                    	minimum = i+j;
                    }
                }
            }
        }
        if(minimum!=987654321) {
        	System.out.println(minimum);
        }else System.out.println(-1);
        
       
    }
}
