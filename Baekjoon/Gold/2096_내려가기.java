import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][3];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] max = new int[N+1][3];
        int[][] min = new int[N+1][3];

        for(int i=0; i<3; i++){
            max[N][i] = map[N][i];
            min[N][i] = map[N][i];
        }

        for(int i=N-1; i>=0; i--){
            max[i][0] = Math.max(max[i+1][0]+map[i][0], max[i+1][1]+map[i][0]);
            max[i][1] = Math.max(max[i+1][0]+map[i][1], Math.max(max[i+1][1]+map[i][1],max[i+1][2]+map[i][1]));
            max[i][2] = Math.max(max[i+1][1]+map[i][2], max[i+1][2]+map[i][2]);

            min[i][0] = Math.min(min[i+1][0]+map[i][0], min[i+1][1]+map[i][0]);
            min[i][1] = Math.min(min[i+1][0]+map[i][1], Math.min(min[i+1][1]+map[i][1],min[i+1][2]+map[i][1]));
            min[i][2] = Math.min(min[i+1][1]+map[i][2], min[i+1][2]+map[i][2]);
        }

        int Max = 0;
        int Min = Integer.MAX_VALUE;

        for(int i=0; i<3; i++){
            Max = Math.max(Max, max[0][i]);
            Min = Math.min(Min, min[0][i]);
        }

        System.out.println(Max+" "+Min);

    }

}
