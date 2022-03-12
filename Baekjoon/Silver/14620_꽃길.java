import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] cost = new int[N][N];
        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                cost[i][j] += map[i][j];
                cost[i][j] += map[i-1][j];
                cost[i][j] += map[i][j-1];
                cost[i][j] += map[i+1][j];
                cost[i][j] += map[i][j+1];
            }
        }
        boolean visited[][] = new boolean[N][N];
        System.out.println(find(0,0,cost, visited));
    }

    private static int find(int cnt,int value,int[][] cost, boolean[][] visit) {
        if(cnt==3){
            return value;
        }
        int result = 987654321;

        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                if(visit[i][j] || visit[i+1][j] || visit[i][j+1] || visit[i-1][j] || visit[i][j-1]) continue;
                visit[i][j] = true;
                visit[i+1][j] = true;
                visit[i][j+1] = true;
                visit[i-1][j] = true;
                visit[i][j-1] = true;
                result = Math.min(result, find(cnt+1, value+cost[i][j], cost,visit));
                visit[i][j] = false;
                visit[i-1][j] = false;
                visit[i][j-1] = false;
                visit[i+1][j] = false;
                visit[i][j+1] = false;
            }
        }

        return result;
    }
}
