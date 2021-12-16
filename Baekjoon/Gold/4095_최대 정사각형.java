import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N==0 && M==0) break;

            int[][] map = new int[N][M];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N-1; i++){
                for(int j=0; j<M-1; j++){
                    if(map[i][j] != 0 && map[i][j+1]!=0 && map[i+1][j]!=0 && map[i+1][j+1]!=0){
                        int min = Math.min(map[i][j+1], map[i+1][j]);
                        min = Math.min(min, map[i][j]);
                        map[i+1][j+1] = min+1;
                    }
                }
            }
            int result = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    result = Math.max(map[i][j], result);
                }
            }

            System.out.println(result);
        }

    }
}
