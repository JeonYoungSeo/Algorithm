import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int cs = sc.nextInt();
        
        for(int i=0; i<cs; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            System.out.printf("%d%02d%n",(c%a==0)?a:c%a, (c%a==0)?c/a : (c/a)+1);
        }
    }
}
