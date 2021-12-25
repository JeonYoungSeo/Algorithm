import java.util.*;
import java.io.*;


public class Main
{

    static int N,M;
    static int[][] map, result;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];



        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 9){
                    result[i][j] = 1; //가능한 자리
                    wind(i-1,j,0);
                    wind(i+1,j,1);
                    wind(i,j-1,2);
                    wind(i,j+1,3);
                }
            }
        }

        int pr = 0;

        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(result[i][j]);
                if(result[i][j] == 1){
                    pr++;
                }
            }
            System.out.println();
        }

        System.out.println(pr);


    }

    static int[] my = {-1,1,0,0};
    static int[] mx = {0,0,-1,1};

    private static void wind(int y, int x, int dir) {
        if(y<0 || x<0 || y>=N || x>=M || map[y][x] == 9){
            return ;
        }

        result[y][x] = 1;

        switch (map[y][x]){
            case 0:
                wind(y+my[dir], x+mx[dir], dir);
                break;
            case 1:
                if(dir == 0 || dir == 1)
                    wind(y+my[dir], x+mx[dir], dir);
                else if(dir==2){
                    wind(y+my[3], x+mx[3], 3);
                }else{
                    wind(y+my[2], x+mx[2], 2);
                }
                break;
            case 2:
                if(dir == 2 || dir == 3)
                    wind(y+my[dir], x+mx[dir], dir);
                else if(dir==0){
                    wind(y+my[1], x+mx[1], 1);
                }else{
                    wind(y+my[0], x+mx[0], 0);
                }
                break;
            case 3:
                if(dir==0){
                    wind(y+my[3], x+mx[3], 3);
                }else if(dir==1){
                    wind(y+my[2], x+mx[2], 2);
                }else if(dir==2){
                    wind(y+my[1], x+mx[1], 1);
                }else if(dir==3){
                    wind(y+my[0], x+mx[0], 0);
                }
                break;
            case 4:

                if(dir==0){
                    wind(y+my[2], x+mx[2], 2);
                }else if(dir==1){
                    wind(y+my[3], x+mx[3], 3);
                }else if(dir==2){
                    wind(y+my[0], x+mx[0], 0);
                }else if(dir==3){
                    wind(y+my[1], x+mx[1], 1);
                }
                break;


        }


    }
}
