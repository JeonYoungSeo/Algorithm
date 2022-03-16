import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] cnt = {0,0,0};
        int[][] pos = new int[N][3];
        int[][] pospos = new int[N][2];
        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                pos[i][j] = -1;
            }
        }
        for(int i=0; i<N; i++){
            char curr = str.charAt(i);
            switch (curr){
                case 'B' :
                    pos[cnt[0]++][0] = i;
                    pospos[i][0] = cnt[0]-1;
                    pospos[i][1] = 0;
                    break;
                case 'O' :
                    pos[cnt[1]++][1] = i;
                    pospos[i][0] = cnt[1]-1;
                    pospos[i][1] = 1;
                    break;
                case 'J' :
                    pos[cnt[2]++][2] = i;
                    pospos[i][0] = cnt[2]-1;
                    pospos[i][1] = 2;
                    break;
            }
        }

        int[][] dp = new int[N][3];
        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = 987654321;
            }
        }
        dp[0][0] = 0;

        for(int i=0; i<N; i++){
            int y = pospos[i][0];
            int x = pospos[i][1];
            int next = (x+1)%3;

            if(dp[y][x]==987654321) continue;

            for(int j=0; j<cnt[next]; j++){
                if(i<pos[j][next]){
                    int dist = i-pos[j][next];
                    dp[j][next] =Math.min(dp[j][next], dp[y][x]+dist*dist);
                }
            }
        }
        int result = dp[pospos[N-1][0]][pospos[N-1][1]];
        if(result == 987654321){
            System.out.println(-1);
        }else
            System.out.println(dp[pospos[N-1][0]][pospos[N-1][1]]);
    }
}
