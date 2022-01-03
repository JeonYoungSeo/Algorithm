import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[][] map, num;
    static int N,M;
    static int[] my = {-1,1,0,0};
    static int[] mx = {0,0,-1,1};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //맵 생성후 입력
        map = new int[N][M];
        num = new int[N][M];
        int[] dp = new int[N*M+1];
        int number = 1;
        //입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 1 && num[i][j] ==0){
                    //1이면 bfs실핼
                    int temp = bfs(i,j,number);
                    dp[number++] = temp;
                }
            }
        }

        int result = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    HashSet<Integer> set = new HashSet<>();
                    int temp = 1;
                    for(int k=0; k<4; k++){
                        int ny = i+my[k];
                        int nx = j+mx[k];

                        if(ny < 0 || nx < 0 || ny>=N || nx >=M || map[ny][nx]==0) continue;

                        if(!set.contains(num[ny][nx])){
                            set.add(num[ny][nx]);
                            temp += dp[num[ny][nx]];
                        }

                    }

                    result = Math.max(result, temp);
                }
            }
        }


        System.out.println(result);

    }



    private static int bfs(int y, int x, int number) {

        num[y][x] = number;

        int result = 1;

        for(int i=0; i<4; i++){
            int ny = y+my[i];
            int nx = x+mx[i];

            if(ny < 0 || nx < 0 || ny>=N || nx >=M) continue;

            if(num[ny][nx] ==0 && map[ny][nx] == 1){
                result += bfs(ny,nx,number);
            }
        }

        return result;
    }


}

