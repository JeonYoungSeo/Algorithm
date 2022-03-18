import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[30];
        arr[1] = 2;
        int[] sum = new int[30];
        sum[1] = 2;
        for(int i=2; i<30; i++){
            arr[i] = arr[i-1]*2;
            sum[i] = sum[i-1]+arr[i];
        }

//        for(int n : arr){
//            System.out.print(n+" ");
//        }
//        System.out.println();
//        for(int n : sum){
//            System.out.print(n+" ");
//        }
        StringBuilder result = new StringBuilder();
        while(N>0){
            int n = 0;
            for(int i=1; i<30; i++){
                if(sum[i]>=N){
                    n = i;
                    break;
                }
            }

            if(N==2){
                result.append("7");
                break;
            }else if(N==1){
                result.append("4");
                break;
            }

            int tmp = N-sum[n-1];
            int half = (sum[n]-sum[n-1])/2;
            if(half<tmp){
                result.append("7");
                N -= half;
            }else{
                result.append("4");
            }
            N -= arr[n-1];
        }

        System.out.println(result);
    }
}
