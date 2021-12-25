import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(min>arr[i]) min = arr[i];
        }

        for(int i=1; i<=min; i++){
            boolean gcd = true;
            for(int j=0; j<n; j++){
                if(arr[j]%i!=0){
                    gcd=false;
                    break;
                }
            }

            if(gcd){
                System.out.println(i);
            }
        }
    }

}
