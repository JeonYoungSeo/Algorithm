import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        if(a==b && b==c){
            System.out.println(10000+1000*a);
        }
        else if(a==b && b!=c){
            System.out.println(1000+100*a);
        }
        else if(a!=b && b==c){
            System.out.println(1000+100*c);
        }
        else if(a==c && a!=b){
            System.out.println(1000+100*c);
        }
        else{
            System.out.println((a>b)?((a>c)?a*100:c*100):((b>c)?b*100:c*100));
        }
    }
}
