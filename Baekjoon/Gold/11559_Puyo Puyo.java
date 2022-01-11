import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static boolean[][] checked;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];

        for(int i=0; i<12; i++){
            String line = br.readLine();
            for(int j=0; j<6; j++){
                map[i][j] = line.charAt(j);
            }
        }

        int result = 0;

        while(true){
            //뿌요~~~ 터뜨리기
            checked = new boolean[12][6];
            boolean escape = true;
            for(int i=0; i<12; i++){
                boolean pass = true;
                for(int j=0; j<6; j++){

                    if(map[i][j] != '.' && !checked[i][j]){

                        int num = check(i,j);

                        if(num >= 4){
                            escape = false;
                            puyo(i,j, map[i][j]);
                        }

                    }

                }
            }

            //터뜨릴거 없으면 탈출
            if(escape) break;

            // 아래로 내리기
            for(int j=0; j<6; j++){
                int bottom = 11;
                for(int i=11; i>=0; i--){
                    if(map[i][j] != '.') {
                        map[bottom][j] = map[i][j];
                        if(bottom!=i){
                            map[i][j] = '.';
                        }
                        bottom--;

                    }
                }
            }


            result ++;
        }

        System.out.println(result);

    }

    private static void puyo(int y, int x, char c) {

        map[y][x] = '.';

        for(int i=0; i<4; i++) {
            int ny = y + my[i];
            int nx = x + mx[i];

            if(isin(ny,nx) && map[ny][nx] == c){
                puyo(ny,nx, c);
            }
        }


    }

    static int[] my = {-1,1,0,0};
    static int[] mx = {0,0,-1,1};

    private static int check(int y, int x) {
        int result = 1;
        checked[y][x] = true;

        for(int i=0; i<4; i++){
            int ny = y + my[i];
            int nx = x + mx[i];

           if(isin(ny,nx) && map[ny][nx] == map[y][x] && !checked[ny][nx]){
                result += check(ny, nx);

               if(result >= 4){
                   return result;
               }
           }
        }
        return result;
    }

    private static boolean isin(int ny, int nx) {

        if(ny<0 || nx<0 || ny>=12 || nx >= 6){
            return false;
        }

        return true;
    }
}
