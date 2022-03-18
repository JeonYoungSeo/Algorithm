import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] mat = new int[N+1][M+1];
        int[][] dpl = new int[N+1][M+1];
        int[][] dpr = new int[N+1][M+1];
        int[][] dpm = new int[N+1][M+1];
        for(int i=0; i<=N-1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
                dpl[i][j] = 987654321;
                dpr[i][j] = 987654321;
                dpm[i][j] = 987654321;
            }
        }
        int result = 987654321;

        for(int i=N-1; i>=0; i--){
            for(int j=M; j>0; j--){
                if(j+1<=M) {
                    dpl[i][j] = Math.min(dpl[i][j], mat[i][j] + dpr[i + 1][j + 1]);
                    dpl[i][j] = Math.min(dpl[i][j], mat[i][j] + dpm[i + 1][j + 1]);
                }
                dpm[i][j] = Math.min(dpm[i][j], mat[i][j]+dpr[i+1][j]);
                dpm[i][j] = Math.min(dpm[i][j], mat[i][j]+dpl[i+1][j]);

                if(j-1>0) {
                    dpr[i][j] = Math.min(dpr[i][j], mat[i][j] + dpm[i + 1][j - 1]);
                    dpr[i][j] = Math.min(dpr[i][j], mat[i][j] + dpl[i + 1][j - 1]);
                }

                if(i==0){
                    result = Math.min(result, dpr[i][j]);
                    result = Math.min(result, dpm[i][j]);
                    result = Math.min(result, dpl[i][j]);
                }

            }
        }

        System.out.println(result);

    }
}
