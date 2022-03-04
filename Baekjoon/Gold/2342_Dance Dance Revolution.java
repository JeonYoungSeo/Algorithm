import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = st.countTokens();
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[N+1][5][5];

        for(int j=0; j<5; j++){
            for(int k=0; k<5; k++){
                dp[0][j][k] = Integer.MAX_VALUE;
            }
        }
        dp[0][0][0] = 0;
        for(int i=1; i<=N; i++){
            int curr = arr[i];
            if(curr==0) break;
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
            //구해야 하는것 curr,right 와 left,curr의 최솟값

            for(int l=0; l<=4; l++){
                if(l==curr) continue;

                for(int r=0; r<=4; r++){
                    if(dp[i-1][l][r]==Integer.MAX_VALUE) continue;
                    int dis = Math.abs(curr-r);
                    int pow = 0;
                    if(dis==0){
                        pow = 1;
                    }else if(dis%2==0){
                        pow = 4;
                    }else{
                        pow = 3;
                    }
                    if(r==0){
                        pow = 2;
                    }
                    dp[i][l][curr] = Math.min(dp[i][l][curr], dp[i-1][l][r]+pow);
                }
            }

            for(int r=0; r<=4; r++){
                if(r==curr) continue;

                for(int l=0; l<=4; l++){
                    if(dp[i-1][l][r]==Integer.MAX_VALUE) continue;
                    int dis = Math.abs(curr-l);
                    int pow = 0;
                    if(dis==0){
                        pow = 1;
                    }else if(dis%2==0){
                        pow = 4;
                    }else{
                        pow = 3;
                    }
                    if(l==0){
                        pow = 2;
                    }
                    dp[i][curr][r] = Math.min(dp[i][curr][r], dp[i-1][l][r]+pow);
                }
            }

//            for(int[] line : dp[i]){
//                for(int n : line){
//                    System.out.print(n+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }

        int result = Integer.MAX_VALUE;

        for(int i=0; i<=4; i++){
            for(int j=0; j<=4; j++){
                result=Math.min(result, dp[N-1][i][j]);
            }
        }

        System.out.println(result);


    }
}
