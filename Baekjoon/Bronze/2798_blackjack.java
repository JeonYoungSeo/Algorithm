import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int result = 0;
        int temp;
        int[] lst = new int[N];
        
        for(int i=0; i<N; i++){
            lst[i] = sc.nextInt();
        }
        
        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++){
                    temp = lst[i]+lst[j]+lst[k];
                    if(temp>result && temp<=M){
                        result = temp;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
