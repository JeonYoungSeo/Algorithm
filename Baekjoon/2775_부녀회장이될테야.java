import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int test = sc.nextInt();
        
        out :for(int i=0; i<test; i++){
            int k = sc.nextInt();
            int n = sc.nextInt();
            n++;
            k++;
            int[][] lst = new int[k][n];
            
            for(int j=1; j<n; j++){
                lst[0][j] = j;
            }
            
            for(int j=1; j<k; j++){
                for(int l=1; l<n; l++){
                    int temp = 0 ;
                    
                    for(int x=1; x<=l; x++){
                        temp += lst[j-1][x];
                    }
                    
                    lst[j][l] = temp;
                    
                    if(j==k-1 && l==n-1){
                        System.out.println(temp);
                        continue out;
                    }
                }
            }
        }
    }
}
