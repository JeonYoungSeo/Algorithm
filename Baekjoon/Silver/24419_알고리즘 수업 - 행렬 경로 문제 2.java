import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];
        int result1 = 0;

        for(int i=1; i<=N; i++){
            map[i][1] = 1;
        }
        for(int i=2; i<=N; i++){
            for(int j=2; j<=i; j++){
                if(map[i-1][j]==0) map[i][j] = (map[i][j-1]*2)%1_000_000_007;
                else map[i][j] = (map[i][j-1] + map[i-1][j])%1_000_000_007;
            }
        }
        for(int i=1; i<=N; i++){
            result1 += ((long)map[N][i]*2)%1_000_000_007;
            result1 = result1%1_000_000_007;
        }

        System.out.println(result1+" "+N*N);
    }
}
