import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());

        int[] arr = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<L; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int n = Integer.parseInt(br.readLine());

        int min = 1;
        int max = -1;



        for(int i=0; i<L; i++){
            if(arr[i] == n){
                System.out.println("0");
                return;
            }
            if(arr[i]<n){
                min = arr[i]+1;
            }else if(arr[i]>n) {
                max = arr[i]-1;
                break;
            }
        }

        int result = 0;



        for(int i=min; i<=n; i++){
            for(int j=n; j<=max; j++){
                if(i==j) continue;
                result++;
            }
        }

        System.out.println(result);
    }
}
