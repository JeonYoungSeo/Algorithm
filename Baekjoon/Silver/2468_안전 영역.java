import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
* 2468 백준 안전영역 문제 .
* 너비우선탐색으로 안잠기는 부분을 구해주면 되는 문제이다. 
*/
public class Main {
    static int N,height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] area = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        int cnt = 0;
        height = 1;
        do{
            int[][] copy = new int[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    copy[i][j] = area[i][j];
                }
            }
            cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(copy[i][j]>height){
                        cnt++;
                        bfs(copy,i,j);
                    }
                }
            }


            result = Math.max(result, cnt);
            height++;
        }while(cnt!=0);

        System.out.println(result);


    }

    static int[] my = {1,-1,0,0};
    static int[] mx = {0,0,1,-1};


    private static void bfs(int[][] copy, int y, int x) {
        copy[y][x] = 0;

        for(int i=0; i<4; i++){
            int ny = y+my[i];
            int nx = x+mx[i];

            if(ny<0 || nx<0 || ny>=N || nx>=N) continue;

            if(copy[ny][nx]>height)
                bfs(copy,ny,nx);

        }

    }
}
