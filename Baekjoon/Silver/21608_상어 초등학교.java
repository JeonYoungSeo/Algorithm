import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int[][] near = new int[N*N+1][4];

        int[] my = {-1,0,1,0};
        int[] mx = {0,-1,0,1};
        for(int i=1; i<=N*N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            //현재 넣을 친구
            int num = Integer.parseInt(st.nextToken());

            //친한 친구 입력
            for(int j=0; j<4; j++){
                near[num][j] = Integer.parseInt(st.nextToken());
            }

            int max_zero = -1;
            int max_bf = -1;
            int pos_y = -1;
            int pos_x = -1;
            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    if(map[y][x] != 0) continue;
                    // 근처 0의 갯수
                    int zero = 0;
                    // 근처 친한 친구 수
                    int bf = 0;
                    //0이면 근처 0의 갯수와 친한친구 갯수 세기
                    for(int z=0; z<4; z++){
                        int ny = y+my[z];
                        int nx = x+mx[z];

                        if(ny<0 || nx<0 || ny>=N || nx>=N) continue;

                        if(map[ny][nx]==0){
                            zero++;
                        }else{
                            //친친 찾기
                            for(int k=0; k<4; k++){
                                if(near[num][k] == map[ny][nx]){
                                    bf++;
                                    break;
                                }
                            }
                        }
                    }

                    if(bf>max_bf){
                        max_bf = bf;
                        max_zero = zero;
                        pos_y = y;
                        pos_x = x;
                    }else if(bf==max_bf && zero>max_zero){
                        max_zero = zero;
                        pos_y = y;
                        pos_x = x;
                    }

                }


            }
            map[pos_y][pos_x] = num;

        }

        int result = 0;

        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                int fr = 0;
                for(int k=0; k<4; k++){
                    int ny = y+my[k];
                    int nx = x+mx[k];
                    if(ny<0 || nx<0 || ny>=N || nx>=N) continue;

                    for(int i=0; i<4; i++){
                        if(map[ny][nx]==near[map[y][x]][i]){
                            fr++;
                            break;
                        }
                    }
                }
                if(fr==0) continue;
                result += Math.pow(10,fr-1);
            }
        }

        System.out.println(result);
    }
}
