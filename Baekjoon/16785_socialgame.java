import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int coin = 0;
        int day = 0;
        
        while(true){
            day ++;
            coin += a;
            if(day%7==0) coin+=b;
            
            if(coin>=c){
                System.out.println(day);
                return;
            }
        }
    }
}
