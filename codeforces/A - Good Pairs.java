import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
 
            int arr[] = new int[n+1];
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = -1;
            int max_n = 0;
            int min = n+1;
            int min_n = 1_000_000_001;
            for(int i=1; i<=n; i++){
                int num = Integer.parseInt(st.nextToken());
 
                if(num>max_n){
                    max = i;
                    max_n = num;
                }
 
                if(num<min_n){
                    min = i;
                    min_n = num;
                }
            }
 
            result.append(min+" "+max+"\n");
        }
 
        System.out.println(result);
    }
}
