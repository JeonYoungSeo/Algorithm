import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<int[]>[] que = new LinkedList[K+1];

        for(int i=1; i<=K; i++){
            que[i] = new LinkedList<>();
        }

        int[][] map = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0){
                    que[map[i][j]].add(new int[] {i, j});
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] my = {1,-1,0,0};
        int[] mx = {0,0,-1,1};

        while(S-->0){

            for(int i=1; i<=K; i++){
                int cnt = que[i].size();
                if(cnt == 0) continue;

                while(cnt-->0){
                    int[] curr = que[i].poll();

                    int x = curr[1];
                    int y = curr[0];

                    for(int j=0; j<4; j++){
                        int ny = y+my[j];
                        int nx = x+mx[j];

                        if(ny<=0 || nx<=0 || ny>N || nx>N) continue;
                        if(map[ny][nx] != 0) continue;

                        map[ny][nx] = map[y][x];
                        que[i].add(new int[] {ny,nx});
                    }
                }
            }
        }
        System.out.println(map[X][Y]);
    }
}
