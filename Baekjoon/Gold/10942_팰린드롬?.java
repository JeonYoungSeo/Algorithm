import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++){
            int size = 0;
            while(true){
                if(i+size>N || i-size<0) break;

                if(arr[i+size] == arr[i-size]){
                    dp[i-size][i+size] = true;
                    size++;
                }else{
                    break;
                }
            }
            int left = i;
            int right = i+1;

            while(true){
                if(left<0 || right>N) break;

                if(arr[left] == arr[right]){
                    dp[left][right] = true;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while(M-->0){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(dp[s][e]){
                result.append(1+"\n");
            }else{
                result.append(0+"\n");
            }

        }

        System.out.println(result);

    }
}


