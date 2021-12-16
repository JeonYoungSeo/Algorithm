import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //맵 생성
        int[][] map = new int[N][M];
        //r c d입력
        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        //맵 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //정답
        int result = 0;

        //0 = 빈 공간, 1 = 벽, 2 = 청소한 곳

        //방향
        int[] dirR = {-1,0,1,0};
        int[] dirC = {0,1,0,-1};

    out : while(true){
            //1. 청소
            if(map[r][c] ==0) {
                map[r][c] = 2;
                result ++;
            }

            
            //2. 왼쪽부터 탐색
            for(int i=1; i<5; i++){
                int newD = (d-i>=0)? d-i : 4+d-i;
                int newR = r + dirR[newD];
                int newC = c + dirC[newD];

                //범위 확인
                if(newR<0 || newC<0 || newR>=N || newC>=M) continue;
                //청소하지 않은 공간 있으면
                if(map[newR][newC]==0){
                    r = newR;
                    c = newC;
                    d = newD;
                    continue out;
                }
            }

            //네 방향에 청소할 곳이 없다
            //뒤에가 벽인지 ??
            if(map[r-dirR[d]][c-dirC[d]] != 1){
                r = r-dirR[d];
                c = c-dirC[d];
                continue ;
            }else{
                break;
            }
        }
        System.out.println(result);
    }
}
